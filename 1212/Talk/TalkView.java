package Talk;



import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yc.bean.Content;
import com.yc.bean.JsonModel;
import com.yc.bean.User;
import com.yc.bean.YcConstants;
import org.eclipse.wb.swt.SWTResourceManager;

public class TalkView {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table;
	private Text text_4;

	private Socket s;
	private Scanner sc;
	private PrintWriter out;

	private Button button; // 联接的按钮
	private Button button_1; // 联接的按钮
	private Button button_2; // 联接的按钮

	private String nickname;
	
	private boolean flag=false;
	

	public static void main(String[] args) {
		try {
			TalkView window = new TalkView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(TalkView.class, "/images/yc.ico"));
		shell.setSize(856, 619);
		shell.setText("\u6E90\u8FB0\u804A\u5929\u5BA4");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);

		Group group = new Group(sashForm, SWT.NONE);
		group.setText("\u8054\u63A5\u914D\u7F6E");

		Label label = new Label(group, SWT.NONE);
		label.setBounds(10, 38, 54, 18);
		label.setText("\u5462\u79F0:");

		text = new Text(group, SWT.BORDER);
		text.setText("cat");
		text.setBounds(78, 38, 70, 18);

		Label lblip = new Label(group, SWT.NONE);
		lblip.setBounds(177, 38, 54, 18);
		lblip.setText("\u670D\u52A1\u5668IP:");

		text_1 = new Text(group, SWT.BORDER);
		text_1.setText("127.0.0.1");
		text_1.setBounds(260, 38, 167, 18);

		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(446, 38, 54, 12);
		label_2.setText("\u7AEF\u53E3:");

		text_2 = new Text(group, SWT.BORDER);
		text_2.setText("23456");
		text_2.setBounds(521, 38, 70, 18);

		button = new Button(group, SWT.NONE);

		button.setBounds(614, 38, 72, 22);
		button.setText("\u8054\u63A5");

		button_1 = new Button(group, SWT.NONE);

		button_1.setEnabled(false);
		button_1.setBounds(719, 38, 72, 22);
		button_1.setText("\u65AD\u5F00");

		Group group_1 = new Group(sashForm, SWT.NONE);
		group_1.setText("\u804A\u5929\u8BB0\u5F55");
		group_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm_1 = new SashForm(group_1, SWT.NONE);

		Composite composite = new Composite(sashForm_1, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		text_3 = new Text(composite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP
				| SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);

		Group group_3 = new Group(sashForm_1, SWT.NONE);
		group_3.setText("\u5728\u7EBF\u7528\u6237\u5217\u8868");
		group_3.setLayout(new FillLayout(SWT.HORIZONTAL));

		table = new Table(group_3, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(150);
		tableColumn.setText("\u5462\u79F0");

		TableColumn tblclmnIp = new TableColumn(table, SWT.NONE);
		tblclmnIp.setWidth(200);
		tblclmnIp.setText("IP");
		sashForm_1.setWeights(new int[] { 470, 369 });

		Group group_2 = new Group(sashForm, SWT.NONE);
		group_2.setText("\u804A\u5929\u4FE1\u606F");

		Label label_1 = new Label(group_2, SWT.NONE);
		label_1.setBounds(36, 29, 54, 18);
		label_1.setText("\u5185\u5BB9:");

		text_4 = new Text(group_2, SWT.BORDER);
		text_4.setBounds(111, 23, 519, 70);

		button_2 = new Button(group_2, SWT.NONE);
	
		button_2.setEnabled(false);
		button_2.setBounds(700, 51, 72, 22);
		button_2.setText("\u53D1\u9001");
		sashForm.setWeights(new int[] { 82, 384, 113 });
		
		//发送
		
		//断开

		//联接
	
	}

	
}
