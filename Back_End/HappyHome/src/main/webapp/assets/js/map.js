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

kakao.maps.event.addListener(map, 'bounds_changed', function() {
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
	let url = 'http://localhost:8080/HappyHome/main?action=map/rest/list&lngFrom=' + swLng + '&lngTo=' + neLng + '&latFrom=' + swLat + '&latTo=' + neLat;
	fetch(url)
		.then((res) => res.json())
		.then((json) => {
			makeList(json);
		})
		.catch((err) => {
			console.log(err);
		});
}


function readTextFile(file) {
	var rawFile = new XMLHttpRequest();
	rawFile.open('GET', file, false);
	rawFile.onreadystatechange = function() {
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
kakao.maps.event.addListener(map, 'drag', function() {
	isMoving = true;
});

kakao.maps.event.addListener(map, 'dragend', function() {
	isMoving = false;
	drawApts();
});

// from live

function initTable(showDate) {
	let tbody = document.querySelector('#aptlist');
	let len = tbody.rows.length;
	for (let i = len - 1; i >= 0; i--) {
		tbody.deleteRow(i);
	}

	// 아파트 리스트의 header를 변경합니다.
	let headerRow = document.querySelector('#aptHeader');
	if (headerRow) {
		// 기존 header를 삭제합니다.
		headerRow.innerHTML = '';

		// 새로운 header를 생성하여 추가합니다.
		let aptHeader = ['아파트이름', '층', '면적', '거래금액'];
		if (showDate) {
			aptHeader.push('거래날짜');
		}

		aptHeader.forEach((item) => {
			let th = document.createElement('th');
			th.appendChild(document.createTextNode(item));
			headerRow.appendChild(th);
		});
	}
}

function viewMap(aptName, aptCode, lat, lng) {
	if (marker != null && infowindow != null) {
		marker.setMap(null);
		infowindow.close();
	}
	
	// 주소-좌표 변환 객체를 생성합니다
	let url = "http://localhost:8080/HappyHome/main?action=map/rest/aptList&aptCode=" + aptCode;
	let tbody = document.querySelector('#aptlist');
	fetch(url)
		.then((res) => res.json())
		.then((jsons) => {
			initTable(true);
			jsons.forEach((json) => {
				let tr = document.createElement('tr');

				let nameTd = document.createElement('td');
				nameTd.appendChild(document.createTextNode(aptName));
				tr.appendChild(nameTd);

				let floorTd = document.createElement('td');
				floorTd.appendChild(document.createTextNode(json.floor));
				tr.appendChild(floorTd);

				let areaTd = document.createElement('td');
				areaTd.appendChild(document.createTextNode(json.area));
				tr.appendChild(areaTd);

				let priceTd = document.createElement('td');
				priceTd.appendChild(document.createTextNode(json.dealAmount + '만원'));
				priceTd.classList.add('text-end');
				tr.appendChild(priceTd);

				let dateTd = document.createElement('td');
				dateTd.appendChild(document.createTextNode(json.dealYear + '/' + json.dealMonth + '/' + json.dealDay));
				dateTd.classList.add('text-end');
				tr.appendChild(dateTd);


				tbody.appendChild(tr);
			});
		});
}
function makeList(jsons) {
	document.querySelector('table').setAttribute('style', 'display: ;');
	let tbody = document.querySelector('#aptlist');
	initTable(false);
	if (marker != null && infowindow != null) {
    	marker.setMap(null);
    	infowindow.close();
  	}
  
	jsons.forEach((json) => {
		let tr = document.createElement('tr');

		let nameTd = document.createElement('td');
		nameTd.appendChild(document.createTextNode(json.apartmentName));
		tr.appendChild(nameTd);

		let floorTd = document.createElement('td');
		floorTd.appendChild(document.createTextNode(json.floor));
		tr.appendChild(floorTd);

		let areaTd = document.createElement('td');
		areaTd.appendChild(document.createTextNode(json.area));
		tr.appendChild(areaTd);

		let priceTd = document.createElement('td');
		priceTd.appendChild(document.createTextNode(json.dealAmount + '만원'));
		priceTd.classList.add('text-end');
		tr.appendChild(priceTd);

		tr.addEventListener('click', () => viewMap(json.apartmentName, json.aptCode, json.lat, json.lng));
		drawOverlay(json.lng, json.lat, json.apartmentName);
		tbody.appendChild(tr);
	});
}

function drawOverlay(lng, lat, apartmentName) {
   var coords = new kakao.maps.LatLng(lat, lng);

  // 결과값으로 받은 위치를 마커로 표시합니다
  marker = new kakao.maps.Marker({
    map: map,
    position: coords,
  });
console.log(lat, lng, apartmentName);
  // 인포윈도우로 장소에 대한 설명을 표시합니다
  infowindow = new kakao.maps.InfoWindow({
    content: `<div style="width:150px;text-align:center;padding:6px 0;">${apartmentName}</div>`,
  });
  infowindow.open(map, marker);
}
