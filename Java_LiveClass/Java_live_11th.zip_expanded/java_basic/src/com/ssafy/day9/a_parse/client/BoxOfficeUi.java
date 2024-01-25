package com.ssafy.day9.a_parse.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssafy.day9.a_parse.dto.BoxOffice;
import com.ssafy.day9.a_parse.parser.BoxOfficeDomParser;
import com.ssafy.day9.a_parse.parser.BoxOfficeJsonParser;
import com.ssafy.day9.a_parse.parser.BoxOfficeParser;

public class BoxOfficeUi extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
    private static final String key = "f5eef3421c602c6cb7ea224104795888";

    // 컴포넌트 선언
    JTextField tfDate;
    JButton btnSearch;
    JTable tblBoxOffice;
    // table의 데이터를 관리하는 객체
    DefaultTableModel model = null;

    BoxOfficeParser parser;

    public static void main(String[] args) {
        BoxOfficeUi ui = new BoxOfficeUi();
        ui.parser = BoxOfficeJsonParser.getParser();

        ui.launchUi();
    }

    private void launchUi() {

        // 테이블 구성
        tblBoxOffice = new JTable();
        tblBoxOffice.setDefaultEditor(Object.class, null);
        String[] header = { "랭킹", "제목", "개봉일", "누적관객" };
        model = (DefaultTableModel) tblBoxOffice.getModel();
        model.setColumnIdentifiers(header);

        // 요소 배치
        this.add(makeNorthPanel(), BorderLayout.NORTH);
        this.add(new JScrollPane(tblBoxOffice), BorderLayout.CENTER);
        // 이벤트 listener 등록 처리
        addEventListener();

        this.setTitle("오늘의 영화 랭킹 Top 10");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setVisible(true);
    }

    private JPanel makeNorthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("조회일자"), BorderLayout.WEST);
        LocalDate date = LocalDate.now().minusDays(1);
        tfDate = new JTextField(String.format("%4d%02d%02d", date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
        panel.add(tfDate, BorderLayout.CENTER);
        btnSearch = new JButton("조회");
        panel.add(btnSearch, BorderLayout.EAST);
        return panel;
    }

    private void addEventListener() {
        btnSearch.addActionListener(e -> {
            // 기존 자료 삭제
            model.setRowCount(0);
            // 새로운 자료 조회
            String targetDt = tfDate.getText();
            // TODO: DateTimeFormatter을 이용해서 날짜의 형태가 yyyyMMdd가 아닐 경우 오류를 메시지로 출력해보자.

            // END

            try (InputStream resource = new URL(String.format("%s?key=%s&targetDt=%s", url, key, targetDt)).openStream()) {
                List<BoxOffice> list = parser.getBoxOffice(resource);
                for (BoxOffice info : list) {
                    model.addRow(
                            new Object[] { info.getRank(), info.getMovieNm(), info.getOpenDt(), info.getAudiAcc() });
                }
                // model의 데이터가 변경되었음을 알림
                model.fireTableDataChanged();

            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });

        // TODO:테이블에서 행을 더블클릭했을 때 발생하는 이벤트를 처리하여 showDetailFrame 메서드를 호출해보자.

        // END
    }

    private JFrame showDetailFrame() {
        JFrame frame = new JFrame();
        int row = tblBoxOffice.getSelectedRow();
        String nm = model.getValueAt(row, 1).toString();
        frame.add(new JLabel(String.format("선택된 영화 제목은 %s입니다.", nm)), BorderLayout.CENTER);
        frame.add(new JLabel("영화에 대한 상세 정보를 출력해보는건 어때요?"), BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

}
