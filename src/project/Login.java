package project;

import utils.BaseFrame;

import utils.RatioPanel;

import static utils.Common.*;
import static utils.RatioPanel.*;
import static db.QueryManager.*;
import static db.QueryManager.*;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.QueryManager;
import db.QueryResult;

public class Login extends BaseFrame {

	private RatioPanel rp;
	private JTextField tf;
	private JPasswordField tfx;
	private JButton bt ,btx;
	
	Login() {
		super("로그인", 300, 200, () -> System.exit(0));
		
	}

	@Override
	protected void initDesign() {
		add(rp = new RatioPanel(new FlowLayout(FlowLayout.CENTER)));
		rp.add(new JLabel("관리자 로그인", JLabel.CENTER) {{setFont(title);}}, 100, 25);
		rp.add(new JLabel("이름", JLabel.LEFT), 20, 15);
		rp.add(tf = new JTextField(), 60, 15);
		rp.add(new JLabel("비밀번호", JLabel.LEFT), 20, 15);
		rp.add(tfx = new JPasswordField(), 60, 15);
		rp.addLine(5);
		rp.add(bt = new JButton("확인"), 30, 23);
		rp.add(btx =new JButton("종료"), 30, 23);
	}

	@Override
	protected void initAction() {
		btx.addActionListener(e -> changeFrame(new Login()));
		bt.addActionListener(e -> {
			if (tf.getText().isBlank() || tfx.getText().isBlank()) {
				errorMessage("공백이 존재합니다.");
				return;
			}
			QueryResult user = LOGIN.executeQuery(tf.getText(), tfx.getText());
			if (user.size() == 0) {
				errorMessage("아이디, 비밀번호를 확인해주세요.");
				return;
			}
			infoMessage("로그인 되었습니다.");
		});
	}

}
