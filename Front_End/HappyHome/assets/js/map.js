var mapContainer = document.getElementById('map'), // 지도를 표시할 div
  mapOption = {
    center: new kakao.maps.LatLng(37.56813, 127.00213), // 지도의 중심좌표
    level: 5, // 지도의 확대 레벨
  };

// 지도를 생성한다
var map = new kakao.maps.Map(mapContainer, mapOption);
var marker, infowindow;

// 지도 타입 변경 컨트롤을 생성한다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도의 상단 우측에 지도 타입 변경 컨트롤을 추가한다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도에 확대 축소 컨트롤을 생성한다
var zoomControl = new kakao.maps.ZoomControl();

// 지도의 우측에 확대 축소 컨트롤을 추가한다
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//MARK: - GeoCoder
// 지도 영역 변화 이벤트
var geocoder = new kakao.maps.services.Geocoder();
var currentCodes = new Set();

kakao.maps.event.addListener(map, 'bounds_changed', function () {
  if (isMoving) {
    return;
  }
  drawApts();
});

function drawApts() {
  var swLat = map.getBounds().getSouthWest().getLat(),
    swLng = map.getBounds().getSouthWest().getLng(),
    neLat = map.getBounds().getNorthEast().getLat(),
    neLng = map.getBounds().getNorthEast().getLng();
  currentCodes = new Set();
  const threshold = 0.01; // 임의의 값으로 설정
  const coords = new Set();
  coords.add({ neLat, neLng });
  for (let lat = swLat; lat <= neLat; lat += threshold) {
    for (let lng = swLng; lng <= neLng; lng += threshold) {
      coords.add({ lat, lng });
    }
  }
  console.log(coords);
  Array.from(coords).forEach(({ lat, lng }) => {
    geocoder.coord2RegionCode(lng, lat, (result, status) => {
      if (status === kakao.maps.services.Status.OK) {
        let code = result[0].code.substr(0, 5);
        if (currentCodes.has(code)) {
          return;
        }

        currentCodes.add(code);
        fetch('/assets/data/' + code + '.json')
          .then((res) => res.json())
          .then((json) => {
            makeList(json);
          })
          .catch((err) => {
            console.log(err);
          });
      }
    });
  });
}

function readTextFile(file) {
  var rawFile = new XMLHttpRequest();
  rawFile.open('GET', file, false);
  rawFile.onreadystatechange = function () {
    if (rawFile.readyState === 4) {
      if (rawFile.status === 200 || rawFile.status == 0) {
        var allText = rawFile.responseText;

        alert(allText);
      }
    }
  };
  rawFile.send(null);
}

var isMoving = false;
kakao.maps.event.addListener(map, 'drag', function () {
  isMoving = true;
});

kakao.maps.event.addListener(map, 'dragend', function () {
  isMoving = false;
  drawApts();
});

// from live

function initTable() {
  let tbody = document.querySelector('#aptlist');
  let len = tbody.rows.length;
  for (let i = len - 1; i >= 0; i--) {
    tbody.deleteRow(i);
  }
}
function viewMap(apt, address) {
  if (marker != null && infowindow != null) {
    marker.setMap(null);
    infowindow.close();
  }
  // 주소-좌표 변환 객체를 생성합니다
  var geocoder = new kakao.maps.services.Geocoder();

  // 주소로 좌표를 검색합니다
  geocoder.addressSearch(address, function (result, status) {
    // 정상적으로 검색이 완료됐으면
    if (status === kakao.maps.services.Status.OK) {
      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

      // 결과값으로 받은 위치를 마커로 표시합니다
      marker = new kakao.maps.Marker({
        map: map,
        position: coords,
      });

      // 인포윈도우로 장소에 대한 설명을 표시합니다
      infowindow = new kakao.maps.InfoWindow({
        content: `<div style="width:150px;text-align:center;padding:6px 0;">${apt}</div>`,
      });
      infowindow.open(map, marker);

      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
      map.panTo(coords);
    }
  });
}
function makeList(jsons) {
  document.querySelector('table').setAttribute('style', 'display: ;');

  let tbody = document.querySelector('#aptlist');
  initTable();
  jsons.forEach((json) => {
    let tr = document.createElement('tr');

    let nameTd = document.createElement('td');
    nameTd.appendChild(document.createTextNode(json.apt));
    tr.appendChild(nameTd);

    let floorTd = document.createElement('td');
    floorTd.appendChild(document.createTextNode(json.floor));
    tr.appendChild(floorTd);

    let areaTd = document.createElement('td');
    areaTd.appendChild(document.createTextNode(json.area));
    tr.appendChild(areaTd);

    let dongTd = document.createElement('td');
    dongTd.appendChild(document.createTextNode(json.dong));
    tr.appendChild(dongTd);

    let priceTd = document.createElement('td');
    priceTd.appendChild(document.createTextNode(json.price + '만원'));
    priceTd.classList.add('text-end');
    tr.appendChild(priceTd);

    let address = json.sojae + ' ' + json.dong + ' ' + json.jibun;
    tr.addEventListener('click', () => viewMap(json.apt, address));

    tbody.appendChild(tr);
  });
}
