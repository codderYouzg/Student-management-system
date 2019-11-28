package com.mec.mis.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.mec.mis.dao.INativeDao;
import com.mec.mis.model.NationModel;
import com.mec.mis.model.NativeModel;
import com.mec.mis.model.SDMModel;
import com.mec.mis.model.StudentDetailModel;
import com.mec.mis.service.SDMService;
import com.mec.util.IMecView;
import com.mec.util.PropertiesParser;

public class StudentMisView implements IMecView {
	private JFrame jfrmMainView;
	
	private JLabel jlblTopic;
	
	private JPanel jpnlButton;
	private JPanel jpnlList;
	private JPanel jpnlBaseInfo;
	
	private JTextField jtxtId;
	private JTextField jtxtStuId;
	private JTextField jtxtName;
	private JLabel jlblSexCaption;
	private JComboBox<NativeModel> jcmbNative;
	private JComboBox<NationModel> jcmbNation;
	private JComboBox<SDMModel> jcmbSchool;
	private JComboBox<SDMModel> jcmbDepartment;
	private JComboBox<SDMModel> jcmbMajor;
	
	private DefaultListModel<StudentDetailModel> dlmStudentList;
	private JList<StudentDetailModel> jlstStudentList;
	private JScrollPane jscpStudentList;
	private JLabel jlblStudentAccount;
	
	private JButton jbtnExit;
	
	private SDMService sdmService;
	
	private static final int FRM_WIDTH = 600;
	private static final int FRM_HEIGHT = 363;
	private static final int lblWidth = normalFont.getSize() * 4;
	private static final int normalFontHeight = normalFont.getSize();
	
	public StudentMisView() {
		sdmService = new SDMService();
		initView();
	}

	@Override
	public void init() {
		jfrmMainView = new JFrame("学生信息管理系统");
		jfrmMainView.setSize(FRM_WIDTH, FRM_HEIGHT);
		jfrmMainView.setLayout(new BorderLayout());
		jfrmMainView.setLocationRelativeTo(null);
		jfrmMainView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jlblTopic = new JLabel("学生信息管理系统", JLabel.CENTER);
		jlblTopic.setFont(topicFont);
		jlblTopic.setForeground(topicColor);
		jfrmMainView.add(jlblTopic, BorderLayout.NORTH);
		
		JLabel jlblWestSpace = new JLabel(" ");
		jlblWestSpace.setFont(normalFont);
		
		JLabel jlblEastSpace = new JLabel(" ");
		jlblEastSpace.setFont(normalFont);
		
		JPanel jpnlWest = new JPanel();
		jpnlWest.add(jlblWestSpace);
		jfrmMainView.add(jpnlWest, BorderLayout.WEST);
		
		JPanel jpnlEast = new JPanel();
		jpnlEast.add(jlblEastSpace);
		jfrmMainView.add(jpnlEast, BorderLayout.EAST);
		
		JPanel jpnlView = new JPanel();
		jpnlView.setLayout(new GridLayout(1, 2));
		jfrmMainView.add(jpnlView, BorderLayout.CENTER);
		
		// 学生基本信息区画板
		jpnlBaseInfo = new JPanel();
		jpnlBaseInfo.setLayout(null);
		jpnlView.add(jpnlBaseInfo);
		
		// 学生列表区画板
		jpnlList = new JPanel();
		jpnlList.setLayout(new BorderLayout());
		jpnlView.add(jpnlList);
		
		dlmStudentList = new DefaultListModel<>();
		jlstStudentList = new JList<>(dlmStudentList);
		jlstStudentList.setFont(normalFont);
		jscpStudentList = new JScrollPane(jlstStudentList);
		TitledBorder ttdbStudentList = new TitledBorder("学生信息列表");
		ttdbStudentList.setTitleFont(normalFont);
		ttdbStudentList.setTitlePosition(TitledBorder.ABOVE_TOP);
		ttdbStudentList.setTitleJustification(TitledBorder.CENTER);
		jscpStudentList.setBorder(ttdbStudentList);
		jpnlList.add(jscpStudentList, BorderLayout.CENTER);
		
		jlblStudentAccount = new JLabel("共0名学生", JLabel.LEFT);
		jlblStudentAccount.setFont(btnFont);
		jpnlList.add(jlblStudentAccount, BorderLayout.SOUTH);

		// 命令按钮区画板
		jpnlButton = new JPanel();
		jpnlButton.setLayout(new FlowLayout());
		jfrmMainView.add(jpnlButton, BorderLayout.SOUTH);
		
		int txtWidth = normalFontHeight * 13;
		int txtHeight = normalFontHeight + 4;
		int lblHeight = normalFontHeight + 2;
		int top = 0;
		int left = lblWidth;
		
		JLabel jlblId = new JLabel("身份证号");
		jlblId.setFont(normalFont);
		jlblId.setBounds(0, 0, lblWidth, lblHeight);
		jpnlBaseInfo.add(jlblId);
		
		jtxtId = new JTextField();
		jtxtId.setFont(normalFont);
		jtxtId.setBounds(left, top+2, txtWidth, txtHeight);
		jpnlBaseInfo.add(jtxtId);
		
		top += lblHeight + PADDING;
		JLabel jlblStuId = new JLabel("学    号");
		jlblStuId.setFont(normalFont);
		jlblStuId.setBounds(0, top, lblWidth, lblHeight);
		jpnlBaseInfo.add(jlblStuId);
		
		jtxtStuId = new JTextField();
		jtxtStuId.setFont(normalFont);
		jtxtStuId.setBounds(left, top+2, txtWidth, txtHeight);
		jpnlBaseInfo.add(jtxtStuId);
		
		top += lblHeight + PADDING;
		JLabel jlblName = new JLabel("姓    名");
		jlblName.setFont(normalFont);
		jlblName.setBounds(0, top, lblWidth, lblHeight);
		jpnlBaseInfo.add(jlblName);
		
		jtxtName = new JTextField();
		jtxtName.setFont(normalFont);
		jtxtName.setBounds(left, top+2, txtWidth, txtHeight);
		jpnlBaseInfo.add(jtxtName);
		
		top += lblHeight + PADDING;
		JLabel jlblSex = new JLabel("性    别");
		jlblSex.setFont(normalFont);
		jlblSex.setBounds(0, top, lblWidth, lblHeight);
		jpnlBaseInfo.add(jlblSex);
		
		jlblSexCaption = new JLabel("", JLabel.CENTER);
		jlblSexCaption.setFont(normalFont);
		jlblSexCaption.setBounds(left, top+2, txtWidth, txtHeight);
		jpnlBaseInfo.add(jlblSexCaption);
		
		top += lblHeight + PADDING;
		JLabel jlblNative = new JLabel("籍    贯");
		jlblNative.setFont(normalFont);
		jlblNative.setBounds(0, top, lblWidth, lblHeight);
		jpnlBaseInfo.add(jlblNative);
		
		jcmbNative = new JComboBox<>();
		jcmbNative.setFont(normalFont);
		jcmbNative.setBounds(left, top-1, txtWidth, txtHeight+2);
		jpnlBaseInfo.add(jcmbNative);
		
		top += lblHeight + PADDING;
		JLabel jlblNation = new JLabel("民    族");
		jlblNation.setFont(normalFont);
		jlblNation.setBounds(0, top, lblWidth, lblHeight);
		jpnlBaseInfo.add(jlblNation);
		
		jcmbNation = new JComboBox<>();
		jcmbNation.setFont(normalFont);
		jcmbNation.setBounds(left, top-1, txtWidth, txtHeight+2);
		jpnlBaseInfo.add(jcmbNation);
		
		top += lblHeight + PADDING;
		JLabel jlblSchool = new JLabel("院    校");
		jlblSchool.setFont(normalFont);
		jlblSchool.setBounds(0, top, lblWidth,  lblHeight);
		jpnlBaseInfo.add(jlblSchool);
		
		jcmbSchool = new JComboBox<>();
		jcmbSchool.setFont(normalFont);
		jcmbSchool.setBounds(left, top-1, txtWidth, txtHeight+2);
		jpnlBaseInfo.add(jcmbSchool);
		
		top += lblHeight + PADDING;
		JLabel jlblDepartment = new JLabel("院    系");
		jlblDepartment.setFont(normalFont);
		jlblDepartment.setBounds(0, top, lblWidth,  lblHeight);
		jpnlBaseInfo.add(jlblDepartment);
		
		jcmbDepartment = new JComboBox<>();
		jcmbDepartment.setFont(normalFont);
		jcmbDepartment.setBounds(left, top-1, txtWidth, txtHeight+2);
		jpnlBaseInfo.add(jcmbDepartment);
		
		top += lblHeight + PADDING;
		JLabel jlblMajor = new JLabel("专    业");
		jlblMajor.setFont(normalFont);
		jlblMajor.setBounds(0, top, lblWidth,  lblHeight);
		jpnlBaseInfo.add(jlblMajor);
		
		jcmbMajor = new JComboBox<>();
		jcmbMajor.setFont(normalFont);
		jcmbMajor.setBounds(left, top-1, txtWidth, txtHeight+2);
		jpnlBaseInfo.add(jcmbMajor);

		jbtnExit = new JButton("退出");
		jbtnExit.setFont(btnFont);
		jpnlButton.add(jbtnExit);
	}

	private INativeDao getNativeDao() {
		String className = PropertiesParser.value("nativeDao");
		try {
			Class<?> klass = Class.forName(className);
			Object object = klass.newInstance();
			if (object instanceof INativeDao) {
				return (INativeDao) object;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public void reinit() {
		INativeDao nativeDao = getNativeDao();

		jcmbNation.removeAllItems();
		jcmbNative.removeAllItems();
		if (nativeDao != null) {
			List<NativeModel> nativeList = nativeDao.getNatives();
			for (NativeModel nativeModel : nativeList) {
				jcmbNative.addItem(nativeModel);
			}
			
			List<NationModel> nationList = nativeDao.getNations();
			for (NationModel  nationModel : nationList) {
				jcmbNation.addItem(nationModel);
			}
		}
		
		List<SDMModel> schools = sdmService.getSchoolList();
		jcmbSchool.removeAllItems();
		for (SDMModel school : schools) {
			jcmbSchool.addItem(school);
		}
		if (jcmbSchool.getItemCount() > 0) {
			jcmbSchool.setSelectedIndex(0);
		} else {
			jcmbDepartment.removeAllItems();
			jcmbMajor.removeAllItems();
		}
		
		initDepartmentBySchool((SDMModel) jcmbSchool.getSelectedItem()); 
		initMajorByDepartment((SDMModel) jcmbDepartment.getSelectedItem());
	}
	
	private void initDepartmentBySchool(SDMModel school) {
		jcmbDepartment.removeAllItems();
		List<SDMModel> departments = sdmService.getDepartment(school.getId());
		for (SDMModel department : departments) {
			jcmbDepartment.addItem(department);
		}
		if (jcmbDepartment.getItemCount() > 0) {
			jcmbDepartment.setSelectedIndex(0);
		} else {
			jcmbMajor.removeAllItems();
		}
	}
	
	private void initMajorByDepartment(SDMModel department) {
		jcmbMajor.removeAllItems();
		List<SDMModel> majors = sdmService.getMajor(department.getId());
		for (SDMModel major : majors) {
			jcmbMajor.addItem(major);
		}
		if (jcmbMajor.getItemCount() > 0) {
			jcmbDepartment.setSelectedIndex(0);
		}
	}

	@Override
	public void dealAction() {
		jfrmMainView.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeView();
			}
		});
	}

	@Override
	public void showView() {
		jfrmMainView.setVisible(true);
	}

	@Override
	public void closeView() {
		jfrmMainView.dispose();
	}
	
}
