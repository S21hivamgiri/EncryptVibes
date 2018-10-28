/*
	1/Jan/2018
	This software as developed by SHIVAM KUMAR GIRI <shivamgiri2015@gmail.com>,Student,
	National Institute of Technolgy,Puducherry
	This s/w is an excellant notepad along with the encryption technique for security feature
	This Notepad uses the Vigenere Code for encryption and hence and be used
	for the programmer as well as general user.
	The message can be send and recieved by other user sharing same network on
	port  11789 for server for sending and port 11790 for recieving The message sent.
*/


/////////////////////////////////Packages/////////////////////////////////////////////
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.text.*;
import java.util.Date;
import java.util.Timer;
import java.util.*;


////////////////////////////////Encryption Vibes//////////////////////////////////////
public class EncryptVibes extends Frame implements WindowListener,ActionListener,KeyListener, MouseListener, Printable
{
public int print(Graphics g, PageFormat pf, int pageIndex) {
    if (pageIndex != 0)
      return NO_SUCH_PAGE;
    Graphics2D g2 = (Graphics2D) g;
    String s=ta2.getText();
    g2.drawString(s, 144, 144);
    return PAGE_EXISTS;
  }
TextArea ta2;Label b12,b13,b14,b36,b32;
TextField tf41,t41,txtf,tfff,tffff;
private Boolean bool = true,boo=true,set=false,iter=false,fal=false,kind=true;
Panel p1,p2,pa1;
String stext,time2,luck;
int count,a,b;
PopupMenu popMenu;
Button b1211,b29;Choice co1;
String message,mass;
Dialog d2,d6,d66,dd1,d661,d55,d77,d44,d121,dd2,d33,dmix,dm2;
Label tf24,bbb,lss;Button b19,b27;
String key="xqujzshivamsanyawv";
public EncryptVibes()
{
	super("EncryptVibes");
	addWindowListener(this);
	setLayout(new BorderLayout());
	/*addWindowFocusListener(new WindowAdapter() {
        public void windowGainedFocus(WindowEvent e) {
        ta2.requestFocusInWindow();
	}
	});*/
	MenuBar menuBar = new MenuBar();
//////////////////////create a Menu object -File////////////////////////////////////////
	Menu fileMenu = new Menu("File");
	MenuItem fm_new = new MenuItem("New");
	fm_new.setShortcut(new MenuShortcut(KeyEvent.VK_N));
	fm_new.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	ta2.setText("");
	tf24.setText("A new File Ready for you, Friend;-)");
	}});

////////////////////////////////////////open/////////////////////////////////////////////
	MenuItem fm_open = new MenuItem("Open");
	FileDialog filec=new FileDialog(this,"Select File to Open",FileDialog.LOAD);
	fm_open.setShortcut(new MenuShortcut(KeyEvent.VK_O));
	fm_open.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent ae){
	tf24.setText("Open your desired file to be edited/encrypted;-)");
	filec.setVisible(true);
	filec.getFile();
	try{
	String dir=filec.getDirectory();
        String fname=filec.getFile();
	FileInputStream fil=new FileInputStream(dir+fname);
	BufferedReader dls=new BufferedReader(new InputStreamReader(fil));
		ta2.setText("");

                String str1="",msg1="";
        	while((str1=dls.readLine())!=null)
                {
                    msg1=msg1+str1;
                    msg1+="\n";
                }
                ta2.setText(msg1);
		tf24.setText("Opened your Desired file, Happy Typing;-)");
                dls.close();
	}
	catch(Exception e){}
	}});

////////////////////////////////////////////save////////////////////////////////////////
	MenuItem fm_save = new MenuItem("Save");
	fm_save.setShortcut(new MenuShortcut(KeyEvent.VK_S));

	FileDialog fd=new FileDialog(this,"Select the location to save",FileDialog.SAVE);
	fm_save.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	tf24.setText("Hey buddy Save the file and have some tea- biscuit, ;-)");
	String txt=ta2.getText();
	fd.setVisible(true);
	try{
	String dir=fd.getDirectory();
        String fname=fd.getFile();
	FileOutputStream file=new FileOutputStream(dir+fname);
	DataOutputStream dos=new DataOutputStream(file);
        dos.writeBytes(txt);
	tf24.setText("Saved successfully:-)");
        dos.close();
	}
	catch(Exception e){}
	}});
	PrinterJob printJob = PrinterJob.getPrinterJob();
	printJob.setPrintable(this);


/////////////////////////////////////////////close///////////////////////////////////////////
	MenuItem fm_print = new MenuItem("Print");
	fm_print.setShortcut(new MenuShortcut(KeyEvent.VK_P));
	fm_print.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Ready for printing=]");
    if (printJob.printDialog()) {
	try {
        printJob.print();
	}
	catch (Exception PrintException) {
        PrintException.printStackTrace();
	}
	}
	}});

	MenuItem fm_close = new MenuItem("Close");
	fm_close.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Wish u had a Happy journey, Hereby Quotext Thanks you and wish you a happy day bbye, ;-|");
	d2.setVisible(true);
	}});

	fm_close.setShortcut(new MenuShortcut(KeyEvent.VK_Q));
	fileMenu.add(fm_new);
	fileMenu.add(fm_open);
	fileMenu.add(fm_print);
	fileMenu.add(fm_save);
	fileMenu.add(fm_close);
	menuBar.add(fileMenu);

////////////////////////////////////////////Edit////////////////////////////////////////////
	Menu fileEdit = new Menu("Edit");
	MenuItem fm_selectall = new MenuItem("Select All");
	fm_selectall.setShortcut(new MenuShortcut(KeyEvent.VK_A));
	fm_selectall.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	ta2.selectAll();
	tf24.setText("Entire Document is selected '-)");
	 }});


/////////////////////////////////////clear////////////////////////////////////////////////
	MenuItem fm_clear = new MenuItem("Clear");
	fm_clear.setShortcut(new MenuShortcut(KeyEvent.VK_W));
	fm_clear.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	ta2.setText("");
	tf24.setText("A Cleared Document Is ready :-)");
	}});

///////////////////////////////////////Cut///////////////////////////////////////////////

	MenuItem fm_cut = new MenuItem("Cut");
	fm_cut.setShortcut(new MenuShortcut(KeyEvent.VK_X));
	fm_cut.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	message=ta2.getSelectedText();
        ta2.replaceRange("",ta2.getSelectionStart(),ta2.getSelectionEnd());
	StringSelection stringSelection = new StringSelection(message);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	clpbrd.setContents(stringSelection, null);
	tf24.setText("Command Recieved , ready to be pasted at desired Location ;-)");
        }});

/////////////////////////////////////Copy/////////////////////////////////////////////////

	MenuItem fm_copy = new MenuItem("Copy");
	fm_copy.setShortcut(new MenuShortcut(KeyEvent.VK_C));
	fm_copy.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	message=ta2.getSelectedText();
	StringSelection stringSelection = new StringSelection(message);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	clpbrd.setContents(stringSelection, null);
	tf24.setText("The Text is copied and ready to be pasted at desired Location;-)");
        }});

//////////////////////////////////////paste//////////////////////////////////////////////
	MenuItem fm_paste = new MenuItem("Paste");
	fm_paste.setShortcut(new MenuShortcut(KeyEvent.VK_V));

	fm_paste.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	try{
	message=(String)clpbrd.getData(DataFlavor.stringFlavor);
	ta2.replaceRange(message,ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("The copied Text is pasted ;-)");
	}catch(Exception ae){}
        }});

	fileEdit.add(fm_selectall);
	fileEdit.add(fm_clear);
	fileEdit.add(fm_cut);
	fileEdit.add(fm_copy);
	fileEdit.add(fm_paste);
	menuBar.add(fileEdit);

////////////////////////////////////////font//////////////////////////////////////
	d55 = new Dialog(this, "Choose Color", true);

	d55.setLayout( new GridLayout(0,1,0,1) );
	Label lab55= new Label("- Choose The Color -");
	lab55.setForeground(Color.white);
	lab55.setBackground(Color.darkGray);
	lab55.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d55.add(lab55, BorderLayout.NORTH);
	d55.setBackground(Color.darkGray);
	Panel pan11= new Panel();
	pan11.setBackground(Color.darkGray);
	Panel pan12= new Panel();
	Button bub1= new Button("  ");
	bub1.setBackground(Color.magenta);
	bub1.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.magenta);
	d55.dispose();
        }});
	pan11.add(bub1);
	Button bub2= new Button("  ");
	bub2.setBackground(Color.white);
	bub2.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.white);
	d55.dispose();
        }});
	pan11.add(bub2);
	Button bub3= new Button("  ");
	bub3.setBackground(Color.yellow);
	bub3.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.yellow);
	d55.dispose();
        }});
	pan11.add(bub3);

	Button bub4= new Button("  ");
	bub4.setBackground(Color.orange);
	bub4.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.orange);
	d55.dispose();
        }});
	pan11.add(bub4);

	Button bub5= new Button("  ");
	bub5.setBackground(Color.green);
	bub5.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.green);
	d55.dispose();
        }});
	pan11.add(bub5);

	Button bub11= new Button("  ");
	bub11.setBackground(Color.cyan);
	bub11.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.cyan);
	d55.dispose();
        }});
	pan12.setBackground(Color.darkGray);
	pan12.add(bub11);

	Button bub12= new Button("  ");
	bub12.setBackground(Color.black);
	bub12.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.black);
	d55.dispose();
        }});
	pan12.add(bub12);
	Button bub13= new Button("  ");
	bub13.setBackground(Color.blue);
	bub13.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.blue);
	d55.dispose();
        }});
	pan12.add(bub13);
	Button bub14= new Button("  ");
	bub14.setBackground(Color.pink);
	bub14.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.pink);
	d55.dispose();
        }});
	pan12.add(bub14);
	Button bub15= new Button("  ");
	bub15.setBackground(Color.red);
	bub15.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setBackground(Color.red);
	d55.dispose();
        }});
	pan12.add(bub15);

	d55.add(pan11);
	d55.add(pan12);
	d55.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d55.dispose();bool=false;
	}
	});
	d55.setTitle("Choose Color");
        d55.setSize(150,100);
	d55.setLocation(400,400);
	d55.pack();
	d44 = new Dialog(this, "Choose Color", true);

	d44.setLayout( new GridLayout(0,1,0,1) );
	Label lab56= new Label("- Choose The Color -");
	lab56.setForeground(Color.white);
	lab56.setBackground(Color.darkGray);
	lab56.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d44.add(lab56, BorderLayout.NORTH);
	d44.setForeground(Color.darkGray);
	Panel pan111= new Panel();
	pan111.setBackground(Color.darkGray);
	Panel pan112= new Panel();
	Button buub1= new Button(" ");
	buub1.setBackground(Color.magenta);
	buub1.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.magenta);
	d44.dispose();
        }});

	pan111.add(buub1);
	Button buub2= new Button("  ");
	buub2.setBackground(Color.white);
	buub2.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.white);
	d44.dispose();
        }});

	pan111.add(buub2);
	Button buub3= new Button("  ");
	buub3.setBackground(Color.yellow);
	buub3.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.yellow);
	d44.dispose();
        }});
	pan111.add(buub3);

	Button buub4= new Button("  ");
	buub4.setBackground(Color.orange);
	buub4.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.orange);
	d44.dispose();
        }});
	pan111.add(buub4);

	Button buub5= new Button("  ");
	buub5.setBackground(Color.green);
	buub5.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.green);
	d44.dispose();
        }});
	pan111.add(buub5);

	Button buub11= new Button("  ");
	buub11.setBackground(Color.cyan);
	buub11.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.cyan);
	d44.dispose();
        }});
	pan112.setBackground(Color.darkGray);
	pan112.add(buub11);


	Button buub12= new Button("  ");
	buub12.setBackground(Color.black);
	buub12.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.black);
	d44.dispose();
        }});
	pan112.add(buub12);
	Button buub13= new Button("  ");
	buub13.setBackground(Color.blue);
	buub13.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.blue);
	d44.dispose();
        }});
	pan112.add(buub13);
	Button buub14= new Button("  ");
	buub14.setBackground(Color.pink);
	buub14.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.pink);
	d44.dispose();
        }});
	pan112.add(buub14);
	Button buub15= new Button("  ");
	buub15.setBackground(Color.red);
	buub15.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	ta2.setForeground(Color.red);
	d44.dispose();
        }});
	pan112.add(buub15);

	d44.add(pan111);
	d44.add(pan112);
	d44.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d44.dispose();
	bool=false;
	}
	});
	d44.setTitle("Choose Color");
        d44.setSize(150,100);
	d44.setLocation(400,400);
	d44.pack();

	Menu fontMenu = new Menu("Font");
	MenuItem fm_bold = new MenuItem("Bold Document ");
	fm_bold.setShortcut(new MenuShortcut(KeyEvent.VK_B));
	fm_bold.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Entire Document is set as BOLD;-)");
	ta2.setFont(new Font(ta2.getFont().getName(), Font.BOLD, ta2.getFont().getSize()));
	}});
	MenuItem fm_plain = new MenuItem("Plain Document ");
	fm_plain.setShortcut(new MenuShortcut(KeyEvent.VK_G));
	fm_plain.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Entire Document is Plainized");
	ta2.setFont(new Font(ta2.getFont().getName(), Font.PLAIN, ta2.getFont().getSize()));
	}});

	dmix=new Dialog(this,"Font",true);
        dmix.setLayout( new GridLayout(0,1,0,1) );
        dmix.setBackground(Color.black);
	dmix.setForeground(Color.white);

	Label lol=new Label("Set the required font:                       ");
        dmix.add(lol);
	lol.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

	GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	Font[] fonts = e.getAllFonts();
    co1 = new Choice();
	co1.setForeground(Color.black);
	co1.setBackground(Color.white);
	for (Font f : fonts) {
	co1.add(f.getFontName());}
	dmix.add(co1);

	Label lq=new Label("                                                 ");
        lq.setBackground(Color.black);
	dmix.add(lq);

        Button btn_no1=new Button("  OK! Set Font ");
	btn_no1.setForeground(Color.black);
	btn_no1.setBackground(Color.white);
	btn_no1.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        btn_no1.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	dmix.dispose();
	ta2.setFont(new Font(co1.getItem(co1.getSelectedIndex()),ta2.getFont().getStyle() , ta2.getFont().getSize()));
	tf24.setText("The require font is selected");
	}
	});
	dmix.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent windowEvent){
        dmix.dispose();
	}
	});
        dmix.setTitle("Set Alarm");
        dmix.setSize(150,100);
	dmix.setLocation(200,200);
	dmix.add(btn_no1, BorderLayout.SOUTH);
	dmix.pack();
	MenuItem fm_font = new MenuItem("Choose Font ");
	fm_font.setShortcut(new MenuShortcut(KeyEvent.VK_J));
	fm_font.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	dmix.setVisible(true);
	tf24.setText("Choose the require font|||");
	}});

	dm2=new Dialog(this,"Font",true);
        dm2.setLayout( new GridLayout(0,1,0,1) );
        dm2.setBackground(Color.black);
	dm2.setForeground(Color.white);

	Label lolo=new Label("Set the size required:      ");
	lolo.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
        dm2.add(lolo);
	Choice co2 = new Choice();
	co2.setForeground(Color.black);
	co2.setBackground(Color.white);
	for (int i=4;i<=72;i=i+2) {
	co2.add(Integer.toString(i));
	}
	dm2.add(co2);
	Label lqa=new Label("                                                 ");
        lqa.setBackground(Color.black);
	dm2.add(lqa);

        Button btn_no7=new Button("  OK! Set Size ");
	btn_no7.setForeground(Color.black);
	btn_no7.setBackground(Color.white);
	btn_no7.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        btn_no7.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	dm2.dispose();
	tf24.setText("The required size of the font is set");
	ta2.setFont(new Font(ta2.getFont().getName(),ta2.getFont().getStyle(),Integer.parseInt(co2.getItem(co2.getSelectedIndex()))  ));
        }
	});

	dm2.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent windowEvent){
        dm2.dispose();
	}
	});
        dm2.setTitle("Set Size");
        dm2.setSize(150,100);
	dm2.setLocation(200,200);
	dm2.add(btn_no7, BorderLayout.SOUTH);
	dm2.pack();

	MenuItem fm_size = new MenuItem("Font Size");
	fm_size.setShortcut(new MenuShortcut(KeyEvent.VK_L));
	fm_size.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Choose the size of the font as required");
	dm2.setVisible(true);
	tf24.setText("The required font size is set");
	}});

	MenuItem fm_color = new MenuItem("Font Color");
	fm_color.setShortcut(new MenuShortcut(KeyEvent.VK_M));
	fm_color.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	d44.setVisible(true);
	tf24.setText("Set the color of the font/text");
	}});

	MenuItem fm_background = new MenuItem("Background");
	fm_background.setShortcut(new MenuShortcut(KeyEvent.VK_I));
	fm_background.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	d55.setVisible(true);
	tf24.setText("Set the back ground color of the text area");
	}});

	fontMenu.add(fm_size);
	fontMenu.add(fm_font);
	fontMenu.add(fm_color);
	fontMenu.add(fm_background);
	fontMenu.add(fm_bold);
	fontMenu.add(fm_plain);
	menuBar.add(fontMenu);

	dd2=new Dialog(this,"Alarm",true);
        dd2.setLayout( new GridLayout(0,1,0,1) );
        dd2.setBackground(Color.black);
	dd2.setForeground(Color.white);

	Label lllbl=new Label("Set the time for Alarm                           ");
        dd2.add(lllbl);
	lllbl.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

	Panel prrr2=new Panel();
	prrr2.setLayout(new GridLayout(1,0,1,0));
	Label ch = new Label("hh");
	prrr2.add(ch);
	ch.setForeground(Color.white);
	Label cm = new Label("mm");
	prrr2.add(cm);
	cm.setForeground(Color.white);
	Label cs = new Label("ss");
	prrr2.add(cs);
	cs.setForeground(Color.white);
	dd2.add(prrr2);
        Panel pr2=new Panel();
	pr2.setLayout(new GridLayout(1,0,1,0));
	Choice c1 = new Choice();
	c1.setForeground(Color.black);
	c1.setBackground(Color.white);
	for(int i=0;i<10;i++)
	c1.add("0"+Integer.toString(i));
	for(int i=10;i<24;i++)
	c1.add(Integer.toString(i));
	pr2.add(c1);
	Choice c2 = new Choice();
	c2.setForeground(Color.black);
	c2.setBackground(Color.white);
	for(int i=0;i<10;i++)
	c2.add("0"+Integer.toString(i));
	for(int i=10;i<60;i++)
	c2.add(Integer.toString(i));
	pr2.add(c2);
	Choice c3 = new Choice();
	c3.setForeground(Color.black);
	c3.setBackground(Color.white);
	for(int i=0;i<10;i++)
	c3.add("0"+Integer.toString(i));
	for(int i=10;i<60;i++)
	c3.add(Integer.toString(i));
	pr2.add(c3);
	dd2.add(pr2);
	Label lbliqi=new Label("                                                   ");
        lbliqi.setBackground(Color.black);
	dd2.add(lbliqi);
	Label lab121=new Label("Set the remainder:                      ");
	dd2.add(lab121);
	lab121.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));

	txtf = new TextField(16);
	txtf.setForeground(Color.black);
	txtf.setBackground(Color.white);
	txtf.setFont(new Font("Verdana", Font.BOLD, 12));
	dd2.add(txtf);
	txtf.addKeyListener(this);
	dd2.add(lbliqi);
	txtf.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent eve){
	luck=txtf.getText();
	}});

        Button btn_no4=new Button("  OK! Set Alarm ");
	btn_no4.setForeground(Color.black);
	btn_no4.setBackground(Color.white);
        btn_no4.addActionListener(this);
	btn_no4.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        btn_no4.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	dd2.dispose();
	kind=true;
	if(kind){
	bbb.setVisible(true);
	luck=txtf.getText();
	time2=c1.getItem(c1.getSelectedIndex())+":"+c2.getItem(c2.getSelectedIndex())+":"+c3.getItem(c3.getSelectedIndex());
	
	Timer timer3 = new Timer();
        timer3.scheduleAtFixedRate(new TimerTask()
	 {
            @Override
            public void run() {
	kind=false;
	String 	time1= new SimpleDateFormat("HH:mm:ss").format(new Date());

 	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	try{
	Date date1 = timeFormat.parse(time1);
	Date date2 = timeFormat.parse(time2);

	long sum = date2.getTime() - date1.getTime();
	String date3 = timeFormat.format(new Date(sum));
	if(time2.compareTo(time1) >= 0)
	{
	bbb.setVisible(true);
	bbb.setText(date3);
	
	tf24.setText("The ALARM is set, the countDown begin");
	
	}
	} catch (ParseException e) {
                e.printStackTrace();
	}
	if(time2.compareTo(time1) == 0)
    	{
	Toolkit.getDefaultToolkit().beep();
	bbb.setVisible(false);
	lss.setText(luck+"             ");
	kind=true;
	tf24.setForeground(Color.red);
	tf24.setText("The ALARM !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
	d33.setVisible(true);
	kind=true;
	Toolkit.getDefaultToolkit().beep();
	}
      	}
        }, 0, 1000);}
        }
	});
	dd2.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        dd2.dispose();
	}
	});
        dd2.setTitle("Set Alarm");
        dd2.setSize(150,100);
	dd2.setLocation(200,200);
	dd2.add(btn_no4, BorderLayout.SOUTH);
	dd2.pack();
/////////////////////////////////////////////alarm notification//////////////////

	d33=new Dialog(this,"Alarm",true);
        d33.setLayout( new GridLayout(0,1,0,1) );
        d33.setBackground(Color.black);
	d33.setForeground(Color.white);
	Label lss2 =new Label("                                                    ");
	lss2.setBackground(Color.black);
	lss2.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        d33.add(lss2);
	lss =new Label("                                               ");
	lss.setForeground(Color.red);
	lss.setBackground(Color.black);
	lss.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        d33.add(lss);
	Label lss1 =new Label("                                                    ");
	lss1.setBackground(Color.black);
	lss1.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        d33.add(lss1);
	Panel py=new Panel();
	py.setLayout(new GridLayout(1,0,1,0));

	Button bnb=new Button("  Dismiss  ");
	bnb.setForeground(Color.black);
	bnb.setBackground(Color.white);
        bnb.addActionListener(this);
	bnb.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
	py.add(bnb);
        bnb.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	d33.dispose();
	
	kind=true;
	tf24.setForeground(Color.cyan);
        }
	});
	Button bnnb=new Button("Snooze:10 mins");
	bnnb.setForeground(Color.black);
	bnnb.setBackground(Color.white);
        bnnb.addActionListener(this);
	bnnb.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
	py.add(bnnb);
        bnnb.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	d33.dispose();
	tf24.setForeground(Color.cyan);
	if(kind)
	{
	kind=false;
	Timer timer6 = new Timer();
        timer6.scheduleAtFixedRate(new TimerTask()
	{
            @Override
            public void run()
	{
	String 	time1= new SimpleDateFormat("HH:mm:ss").format(new Date());
	String time3="00:10:00";
 	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	long tim;
	timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	try{
	Date date1 = timeFormat.parse(time1);
	Date date2 = timeFormat.parse(time2);
	Date date3 = timeFormat.parse(time3);
	long sum = date2.getTime() + date3.getTime();
	long sum1=sum- date1.getTime();
	tim=date2.getTime()+date3.getTime();
	String date4 = timeFormat.format(new Date(sum1));

	bbb.setVisible(true);
	if(date4.compareTo("00:00:00") >= 0)
	bbb.setText(date4);

	if(date4.compareTo("00:00:00") == 0)
    	{
	Toolkit.getDefaultToolkit().beep();
	bbb.setVisible(false);
	lss.setText(luck+"             ");
	kind=true;
	d33.setVisible(true);
	Toolkit.getDefaultToolkit().beep();
	time2=timeFormat.format(new Date(tim));
	}
	} catch (ParseException e) {
                e.printStackTrace();
	}
      	}}, 0, 1000);
	}
        }
	});
	d33.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d33.dispose();
	tf24.setForeground(Color.cyan);
	}
	});
        d33.setTitle("Alarm Notification");
        d33.setSize(650,600);
	d33.setLocation(600,200);
	d33.add(py, BorderLayout.SOUTH);
	d33.pack();
//////////////////////////////////////////////Insert////////////////////////////

	Menu insertMenu = new Menu("Insert");
	MenuItem fm_date = new MenuItem("Date");
	fm_date.setShortcut(new MenuShortcut(KeyEvent.VK_Y));
	fm_date.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	String string = new SimpleDateFormat(" dd/MM/yyyy" ).format(new Date());
 	ta2.replaceRange(string,ta2.getSelectionStart(),ta2.getSelectionEnd());
	}});
	insertMenu.add(fm_date);

	MenuItem fm_time = new MenuItem("Time");
	fm_time.setShortcut(new MenuShortcut(KeyEvent.VK_Z));
	fm_time.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	String string = new SimpleDateFormat(" hh:mm:ss a" ).format(new Date());
 	ta2.replaceRange(string,ta2.getSelectionStart(),ta2.getSelectionEnd());
	}});
	insertMenu.add(fm_time);

	MenuItem fm_alarm = new MenuItem("Alarm");
	fm_alarm.setShortcut(new MenuShortcut(KeyEvent.VK_U));
	fm_alarm.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	dd2.setVisible(true);
	kind=true;
	}});
	insertMenu.add(fm_alarm);
	menuBar.add(insertMenu);

////////////////////////////////////find and replace////////////////////////////////////////////
	d661 = new Dialog(this, "Find", true);
	d661.setBackground(Color.black);
	d661.setLayout( new GridLayout(0,1,0,1) );
	b27 = new Button(" Next ");
	b27.setForeground(Color.black);
	b27.setFont(new Font("Verdana", Font.BOLD, 14));
	b27.setBackground(Color.white);
	Label l37= new Label("-     Type the word to search          -");
	l37.setForeground(Color.white);
	l37.setBackground(Color.black);
	l37.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d661.add(l37);
	tf41 = new TextField(24);
	tf41.setForeground(Color.black);
	tf41.setBackground(Color.white);
	tf41.addKeyListener(this);
	tf41.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent eve){
	boo=true;
	set=false;
	String txt = ta2.getText();
        String Find =tf41.getText();
	int M = Find.length();
        int N = txt.length();
        int long_ps[] = new int[M];
        int j = 0;
        int len = 0;
        int i = 1;
        long_ps[0] = 0;
        while (i < M)
        {
            if (Find.charAt(i) == Find.charAt(len))
            {
                len++;
                long_ps[i] = len;
                i++;
            }
            else
	   {
		 if (len != 0)
                {
                    len = long_ps[len-1];
                }
                else
                {
                    long_ps[i] = len;
                    i++;
                }
            }
        }

        i = 0;
        while (i < N)
        {
            if (Find.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
    		if(boo)
		{
		set=true;
		d661.setVisible(false);
		ta2.select(i-j,i-j+Find.length());
		d661.setVisible(true);

		}
		else
			break;
            }

            else if (i < N && Find.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = long_ps[j-1];
                else
                    i = i+1;
            }
        }
	ta2.select(0,0);
	boo=false;set=false;
	}});

	Label l371= new Label("Press Enter to set the text in textbox");
	l371.setForeground(Color.red);
	l371.setBackground(Color.black);
	l371.setFont(new Font("TimesNewRoman", Font.PLAIN, 11));
	d661.add(l371);
	tf41.setFont(new Font("Verdana", Font.BOLD, 12));
	d661.add(tf41);
	b27.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	if (set)
   	d661.dispose();
        }});
	b27.addKeyListener(this);
	d661.add(b27, BorderLayout.SOUTH);
	d661.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d661.dispose();
	boo=false;
	set=false;
	}
	});
	d661.setTitle("Search Result");
        d661.setSize(150,100);
	d661.setLocation(1000,00);
	d661.pack();
	d77 = new Dialog(this, "Find and Replace", true);
	d77.setBackground(Color.black);
	d77.setLayout( new GridLayout(0,1,0,1) );
	Label li37= new Label("-   Type the word to search  and replace -");
	li37.setForeground(Color.white);
	li37.setBackground(Color.black);
	li37.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d77.add(li37);
	Label liy37= new Label("Press Enter to set the text in replace box");
	liy37.setForeground(Color.red);
	liy37.setBackground(Color.black);
	liy37.setFont(new Font("TimesNewRoman", Font.PLAIN, 11));
	d77.add(liy37);
	Panel PPP=new Panel();
	Label ll371m= new Label("Search:         ");
	ll371m.setForeground(Color.white);
	ll371m.setBackground(Color.black);
	ll371m.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	PPP.add(ll371m);
	tfff = new TextField(24);
	PPP.add(tfff);
	tfff.setForeground(Color.black);
	tfff.setBackground(Color.white);
	tfff.addKeyListener(this);
	tfff.setFont(new Font("Verdana", Font.BOLD, 12));
	d77.add(PPP);
	Panel PPPm=new Panel();
	Label ll371k= new Label("Replace With:");
	ll371k.setForeground(Color.white);
	ll371k.setBackground(Color.black);
	ll371k.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	PPPm.add(ll371k);
	tffff = new TextField(24);
	PPPm.add(tffff);
	tffff.setForeground(Color.black);
	tffff.setBackground(Color.white);
	tffff.addKeyListener(this);
	tffff.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent eve){
	boo=true;
	set=false;
	fal=false;
	String txt = ta2.getText();
        String Find =tfff.getText();
	int M = Find.length();
        int N = txt.length();
        int long_ps[] = new int[M];
        int j = 0;
        int len = 0;
        int i = 1;
        long_ps[0] = 0;
        while (i < M)
        {
            if (Find.charAt(i) == Find.charAt(len))
            {
                len++;
                long_ps[i] = len;
                i++;
            }
            else
	   {
		 if (len != 0)
                {
                    len = long_ps[len-1];
                }
                else
                {
                    long_ps[i] = len;
                    i++;
                }
            }
        }

        i = 0;
        while (i < N)
        {
            if (Find.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
    		if(boo)
		{
		set=true;
		d77.setVisible(false);
		fal=true;
		ta2.select(i-j,i-j+Find.length());
		a=ta2.getSelectionStart();
		b=ta2.getSelectionEnd();
		d77.setVisible(true);
		fal=false;
                j = long_ps[j-1];
		}
		else
		break;
            }

            else if (i < N && Find.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = long_ps[j-1];
                else
                    i = i+1;
            }
        }
	ta2.select(0,0);
	boo=false;
	set=false;
	fal=false;
	}});

	tffff.setFont(new Font("Verdana", Font.BOLD, 12));
	d77.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent windowEvent){
        d77.dispose();
	boo=false;
	set=false;
	}
	});
	d77.add(PPPm);
	Panel pann=new Panel();
        Button btn_find=new Button("Find ");
	btn_find.setFont(new Font("TimesNewRoman", Font.PLAIN,12));
        btn_find.setBackground(Color.white);
	btn_find.setForeground(Color.black);
	btn_find.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Should this be Replaced?");
	if (set)
   	d77.dispose();
	}});
        Button btn_replace=new Button(" Replace ");
	btn_replace.setForeground(Color.black);
	btn_replace.setBackground(Color.white);
        btn_replace.addActionListener(this);
	btn_replace.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        btn_replace.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("The matching Text is replaced");
	if(fal)
	ta2.replaceRange(tffff.getText(),a,b);
        }
	});
	Button btn_replaceall=new Button("  ReplaceAll ");
	btn_replaceall.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));

	btn_replaceall.setForeground(Color.black);
	btn_replaceall.setBackground(Color.white);
	btn_replaceall.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae){
	tf24.setText("All the word matching this are replaced");
	boo=true;
	set=false;
	String txt = ta2.getText();
        String Find =tfff.getText();
	int M = Find.length();
        int N = txt.length();
        int long_ps[] = new int[M];
        int j = 0;
        int len = 0;
        int i = 1;
        long_ps[0] = 0;
        while (i < M)
        {
            if (Find.charAt(i) == Find.charAt(len))
            {
                len++;
                long_ps[i] = len;
                i++;
            }
            else
	   {
		 if (len != 0)
                {
                    len = long_ps[len-1];
                }
                else
                {
                    long_ps[i] = len;
                    i++;
                }
            }
        }

        i = 0;
        while (i < N)
        {
            if (Find.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
		{
		ta2.select(i-j,i-j+Find.length());
		ta2.replaceRange(tffff.getText(),ta2.getSelectionStart(),ta2.getSelectionEnd());
		j = long_ps[j-1];
		}

            else if (i < N && Find.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = long_ps[j-1];
                else
                    i = i+1;
            }
        }
	ta2.select(0,0);
	boo=false;
	set=false;
  	}});
	pann.add(btn_find,BorderLayout.WEST);
	pann.add(btn_replace,BorderLayout.CENTER);
        pann.add(btn_replaceall,BorderLayout.EAST);
	pann.setLayout(new GridLayout(1,0,1,0));
	pann.setBackground(Color.black);
	d77.add(pann,BorderLayout.SOUTH);
	d77.setTitle("Search Result");
        d77.setSize(150,100);
	d77.setLocation(400,200);
	d77.pack();

	Menu SearchMenu = new Menu("Search");
	MenuItem fm_fn = new MenuItem("Find");
	fm_fn.setShortcut(new MenuShortcut(KeyEvent.VK_F));
	fm_fn.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	d661.setVisible(true);
	}
	});
	MenuItem fm_rep = new MenuItem("Replace");
	fm_rep.setShortcut(new MenuShortcut(KeyEvent.VK_H));
	fm_rep.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	d77.setVisible(true);
        }});
	SearchMenu.add(fm_fn);
	SearchMenu.add(fm_rep);
	menuBar.add(SearchMenu);

/////////////////////////////////////Encryption////////////////////////////////////////////////////
	Menu CryptMenu = new Menu("Security");
	MenuItem fm_en = new MenuItem("Encrypt Document");
	fm_en.setShortcut(new MenuShortcut(KeyEvent.VK_E));

	fm_en.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){

	tf24.setText("Hey This is Viginere Encryption!! Safer to use and Quite Hard to be decrypted:-}");
	if(iter)
	key=mass;
	String netkey="";
	String code=ta2.getText();
	int t=code.length();
	int x=key.length();
	int z=t/x+1;
	for(int i=0;i<z;i++)netkey+=key;
        char[] re= new char[t];
	char[] ch=code.toCharArray();
	char[] keyi=netkey.toCharArray();
	for(int i=0;i<t;i++)
	{   re[i]=ch[i];
	if(Character.isLetter(ch[i]))
	{
		if(Character.isUpperCase(ch[i]))
		{
		int y=(char)keyi[i]+(char)ch[i]-96;
		if(y>90)
		{y=y-26;
		}
		re[i]=(char)y;
		}
		else if(Character.isLowerCase(ch[i]))
		{
			int y=(char)keyi[i]+(char)ch[i]-96;
			if(y>122)
		{
		y=y-26;
		}
		re[i]=(char)y;
		}
	}
	else if(Character.isDigit(ch[i]))
	{
	int y=9-ch[i]+48;
	re[i]=Character.forDigit(y,12);
	}
		else if(ch[i]==' ')
	{re[i]='`';
	}
		else if(ch[i]=='`')
	{re[i]=' ';
	}
		else if(ch[i]=='$')
	{re[i]='@';
	}
		else if(ch[i]=='@')
	{re[i]='$';
	}
		else if(ch[i]=='{')
	{re[i]='[';
	}
		else if(ch[i]=='[')
	{re[i]='(';
	}
		else if(ch[i]=='(')
	{re[i]='{';
	}
		else if(ch[i]=='}')
	{re[i]=']';
	}
		else if(ch[i]==']')
	{re[i]=')';
	}
		else if(ch[i]==')')
	{re[i]='}';
	}
		else if(ch[i]=='&')
	{re[i]='|';
	}
		else if(ch[i]=='|')
	{re[i]='&';
	}
		else if(ch[i]=='>')
	{re[i]='<';
	}
		else if(ch[i]=='<')
	{re[i]='>';
	}
		else if(ch[i]=='.')
	{re[i]=',';
	}
		else if(ch[i]==',')
	{re[i]='?';
	}
		else if(ch[i]=='?')
	{re[i]='.';
	}
		else if(ch[i]=='+')
	{re[i]='-';
	}
		else if(ch[i]=='-')
	{re[i]='/';
	}
		else if(ch[i]=='/')
	{re[i]='*';
	}
		else if(ch[i]=='*')
	{re[i]='+';
	}
		else if(ch[i]=='=')
	{re[i]=';';
	}
		else if(ch[i]==';')
	{re[i]='"';
	}
		else if(ch[i]=='"')
	{re[i]='#';
	}
		else if(ch[i]=='#')
	{re[i]='%';
	}
		else if(ch[i]=='%')
	{re[i]='^';
	}
		else if(ch[i]=='^')
	{re[i]=':';
	}
		else if(ch[i]==':')
	{re[i]='~';
	}
		else if(ch[i]=='~')
	{re[i]='=';
	}
	}
	String ter1="";
	for(int i=0;i<t;i++)
	ter1+=re[i];
	ta2.setText(ter1);
        }});

///////////////////////////////////////////Decryption///////////////////////////////////////////
	MenuItem fm_de = new MenuItem("Decrypt Document");
	fm_de.setShortcut(new MenuShortcut(KeyEvent.VK_D));
	fm_de.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Hola, Your text is decrypted!! Enjoy -Read the message ");
	if(iter)
	key=mass;
	String netkey="";
	String decode=ta2.getText();
	int t=decode.length();
	int x=key.length();
	int z=t/x+1;
	for(int i=0;i<z;i++)netkey+=key;
        char[] de= new char[t];
	char[] ch=decode.toCharArray();
	char[] keyi=netkey.toCharArray();
	for(int i=0;i<t;i++)
	{
	de[i]=ch[i];
	if(Character.isLetter(ch[i]))
	{
		if(Character.isUpperCase(ch[i]))
		{
		int y=-(char)keyi[i]+(char)ch[i]+96;
		if(y<65)
		{
			y=y+26;
		}
		de[i]=(char)y;
		}
		else if(Character.isLowerCase(ch[i]))
		{
			int y=-(char)keyi[i]+(char)ch[i]+96;

			if(y<97)
		{y=y+26;
		}
			de[i]=(char)y;
		}
	}
	else if(Character.isDigit(ch[i]))
	{
	int y=9-ch[i]+48;
	de[i]=Character.forDigit(y,12);
	}
	else if(ch[i]=='`')
	{de[i]=' ';
	}
		else if(ch[i]==' ')
	{de[i]='`';
	}
		else if(ch[i]=='$')
	{de[i]='@';
	}
		else if(ch[i]=='@')
	{de[i]='$';
	}
		else if(ch[i]=='{')
	{de[i]='(';
	}
		else if(ch[i]=='[')
	{de[i]='{';
	}
		else if(ch[i]=='(')
	{de[i]='[';
	}
		else if(ch[i]=='}')
	{de[i]=')';
	}
		else if(ch[i]==']')
	{de[i]='}';
	}
		else if(ch[i]==')')
	{de[i]=']';
	}
		else if(ch[i]=='&')
	{de[i]='|';
	}
		else if(ch[i]=='|')
	{de[i]='&';
	}
		else if(ch[i]=='>')
	{de[i]='<';
	}
		else if(ch[i]=='<')
	{de[i]='>';
	}
		else if(ch[i]=='.')
	{de[i]='?';
	}
		else if(ch[i]==',')
	{de[i]='.';
	}
		else if(ch[i]=='?')
	{de[i]=',';
	}
		else if(ch[i]=='+')
	{de[i]='*';
	}
		else if(ch[i]=='-')
	{de[i]='+';
	}
		else if(ch[i]=='/')
	{de[i]='-';
	}
		else if(ch[i]=='*')
	{de[i]='/';
	}
		else if(ch[i]=='=')
	{de[i]='~';
	}
		else if(ch[i]==';')
	{de[i]='=';
	}
		else if(ch[i]=='"')
	{de[i]=';';
	}
		else if(ch[i]=='#')
	{de[i]='"';
	}
		else if(ch[i]=='%')
	{de[i]='#';
	}
		else if(ch[i]=='^')
	{de[i]='%';
	}
		else if(ch[i]==':')
	{de[i]='^';
	}
	}
	String ter="";
	for(int i=0;i<t;i++)ter+=de[i];
	ta2.setText(ter);
	}});
	CryptMenu.add(fm_en);
	CryptMenu.add(fm_de);
	menuBar.add(CryptMenu);


//////////////////////////////////////////Recieving//////////////////////////////////////////
	d6=new Dialog(this,"RecieveMode",true);
        d6.setLayout( new GridLayout(0,1,0,1) );
        d6.setBackground(Color.black);
	d6.setForeground(Color.white);

	Label labol=new Label(" Do you want to save before Recieving ?? ");
        d6.add(labol);
	labol.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        Panel panelty=new Panel();

	Label bail=new Label("                                 ");
        bail.setBackground(Color.black);
	d6.add(bail);
	Label baili=new Label("                                 ");
        baili.setBackground(Color.black);
	d6.add(baili);

        Button caseno=new Button(" No ");
	caseno.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        caseno.setForeground(Color.black);
	panelty.setBackground(Color.white);

	caseno.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	d6.dispose();
	try{
		DatagramSocket clientsocket;
		DatagramPacket dp;
		BufferedReader dis;
		InetAddress ia;
		byte buf[] = new byte[1024];
		int cport = 11789,sport=11790;
		clientsocket = new DatagramSocket(sport);
	try{	clientsocket.setSoTimeout(10000);
	
		dp = new DatagramPacket(buf,buf.length);
		tf24.setText("Recieving mode is activated for 10 secs, EncryptVibes may hang down to recieve data");
		dis = new BufferedReader (new InputStreamReader(System.in));
		ia = InetAddress.getLocalHost();
		clientsocket.receive(dp);
		String str = new String(dp.getData(), 0,dp.getLength());
		ta2.setText(str);
		tf24.setText("Recieving mode Ended");
		clientsocket.close();
		throw new SocketTimeoutException();
		}
		catch(SocketTimeoutException aeio)
		{
		tf24.setText("Recieving mode Ended");
		clientsocket.close();
		}
	}
	catch(Exception ae){}
	}
  	});

	Button replaceyes=new Button(" Yes ");
	replaceyes.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        panelty.add(replaceyes);
	panelty.add(caseno);
	replaceyes.setForeground(Color.black);
	replaceyes.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae){
	String txt=ta2.getText();
	fd.setVisible(true);
	try{
		String dir=fd.getDirectory();
		String fname=fd.getFile();
		FileOutputStream file=new FileOutputStream(dir+fname);
		DataOutputStream dos=new DataOutputStream(file);
		dos.writeBytes(txt);
		dos.close();
	}
	catch(Exception e){}
        d6.dispose();
	try{
		DatagramSocket clientsocket;
		DatagramPacket dp;
		BufferedReader dis;
		InetAddress ia;
		byte buf[] = new byte[1024];
		int cport = 11789,sport=11790;
		tf24.setText("File is Saved and Recieving mode is activated for 10 secs, EncryptVibes may hang down to recieve data");
		clientsocket = new DatagramSocket(sport);
	try{	clientsocket.setSoTimeout(10000);
	
		dp = new DatagramPacket(buf,buf.length);
		dis = new BufferedReader (new InputStreamReader(System.in));
		ia = InetAddress.getLocalHost();
		clientsocket.receive(dp);
		String str = new String(dp.getData(), 0,dp.getLength());
		ta2.setText(str);
		tf24.setText("Recieving mode Ended");
		clientsocket.close();
	throw new SocketTimeoutException();
		}
		catch(SocketTimeoutException aeio)
		{
		tf24.setText("Recieving mode Ended");
		clientsocket.close();
		}
	}
	catch(Exception aei){}
        }
  	});
	Button canc=new Button("Cancel Recieving mode");
	canc.setForeground(Color.black);
        panelty.add(canc);
	canc.setBackground(Color.white);
	canc.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));

	canc.addActionListener(new ActionListener()
	{@Override
	public void actionPerformed(ActionEvent e){
	d6.dispose();
	tf24.setText("Recieving Mode is Terminated");
        }
	});
	d6.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d6.dispose();
	}
	});
        d6.setTitle("Recieve Mode");
        d6.setSize(150,100);
	d6.setLocation(200,200);
	panelty.setLayout(new GridLayout(1,0,1,0));
	d6.add(panelty, BorderLayout.SOUTH);
	d6.pack();

///////////////////////////////////////////networking///////////////////////////////////
	Menu NetworkMenu = new Menu("Network");
	MenuItem fm_rec = new MenuItem("Recieve Mode");
	fm_rec.setShortcut(new MenuShortcut(KeyEvent.VK_R));
	fm_rec.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Save the file as recieving data may overwrite the existing data");
	d6.setVisible(true);
	}});

	MenuItem fm_res = new MenuItem("Send'");
	fm_res.setShortcut(new MenuShortcut(KeyEvent.VK_T));
	fm_res.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	try{
	DatagramSocket serversocket;
	DatagramPacket dp;
	BufferedReader dis;
	InetAddress ia;
	byte buf[] = new byte[12345];
	int cport = 11789, sport = 11790;
	serversocket = new DatagramSocket(cport);
	tf24.setText("The Document text is send over to the network, Reciever should be set in Reciever Mode to recieve");
	dp = new DatagramPacket(buf, buf.length);
	dis = new BufferedReader(new InputStreamReader(System.in));
	ia = InetAddress.getLocalHost();
	String str = new String(ta2.getText());
	buf = str.getBytes();
	serversocket.send(new DatagramPacket(buf,str.length(), ia, sport));
	serversocket.close();
	}
	catch(Exception ae){}
	}});
	NetworkMenu.add(fm_rec);
	NetworkMenu.add(fm_res);
	menuBar.add(NetworkMenu);


//////////////////////////////////////////advance////////////////////////////////////////
	d121 = new Dialog(this, "Encryption Key", true);
	d121.setBackground(Color.black);
	d121.setLayout( new GridLayout(0,1,0,1) );
	b1211 = new Button(" Change One Time ");
	b1211.setForeground(Color.black);
	b1211.setFont(new Font("Verdana", Font.BOLD, 14));
	b1211.setBackground(Color.white);
	Label l3232= new Label("-   Type new Encryption Key -");
	l3232.setForeground(Color.white);
	l3232.setBackground(Color.black);
	l3232.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d121.add(l3232);
	t41 = new TextField(16);
	t41.setForeground(Color.black);
	t41.setBackground(Color.white);
	t41.addKeyListener(this);
	t41.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent eve){
	mass=t41.getText();
	iter=true;

	}});

	Label ll32321= new Label(" Type Only small letters ");
	ll32321.setForeground(Color.red);
	ll32321.setBackground(Color.black);
	ll32321.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
	d121.add(ll32321);

	Label l32321= new Label("One Time Key:   ");
	l32321.setForeground(Color.white);
	l32321.setBackground(Color.black);
	l32321.setFont(new Font("TimesNewRoman", Font.ITALIC, 12));
	d121.add(l32321);
	t41.setFont(new Font("Verdana", Font.BOLD, 12));
	d121.add(t41);
	b1211.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Change The one time key for the encryption");
	mass=t41.getText();
	iter=true;
   	d121.dispose();
        }});
	b1211.addKeyListener(this);
	d121.add(b1211, BorderLayout.SOUTH);
	d121.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d121.dispose();
	}
	});
	d121.setTitle("Encryption key");
        d121.setSize(150,100);
	d121.setLocation(1000,100);
	d121.pack();

	Menu advanceMenu = new Menu("Advance");
	MenuItem fm_advance = new MenuItem("Change Encryption key ");
	fm_advance.setShortcut(new MenuShortcut(KeyEvent.VK_K));
	fm_advance.addActionListener(new ActionListener(){@Override
	public void actionPerformed(ActionEvent e){
	d121.setVisible(true);
	}});
	advanceMenu.add(fm_advance);
	menuBar.add(advanceMenu);


//////////////////////////////////////////////about /////////////////////////////////////
	Menu AboutMenu = new Menu("About");
	MenuItem fm_c = new MenuItem("Creator Info");
	fm_c.setShortcut(new MenuShortcut(KeyEvent.VK_F1));
	Dialog d1 = new Dialog(this, "Creator Info", true);
	d1.setLayout( new GridLayout(0,1,0,1) );

	Label l1= new Label("This application was developed by:");
	l1.setForeground(Color.black);
	l1.setBackground(Color.white);
	d1.setBackground(Color.white);
	d1.add(l1);

	Label l2= new Label("Shivam Kumar Giri");
	l2.setForeground(Color.red);
	l2.setBackground(Color.white);
	l2.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
	d1.add(l2);

	Label l3= new Label("For further suggestion Contact me at:");
	l3.setForeground(Color.black);
	l3.setBackground(Color.white);
	d1.add(l3);

	Label l4= new Label("shivamgiri2015@gmail.com");
	l4.setForeground(Color.blue);
	l4.setBackground(Color.white);
	l4.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
	d1.add(l4);

	Label l25= new Label("                \n\n               ");;
	l25.setBackground(Color.white);
	l25.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));

	d1.add(l25);
	Label l5= new Label("- Stay Happy, Enjoy your Life   ;-)");
	l5.setForeground(Color.black);
	l5.setBackground(Color.white);
	l5.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d1.add(l5);
	d1.setSize(300,300);
	d1.pack();
	d1.setLocation(320, 170);

        d1.addWindowListener(new WindowAdapter(){
	public void windowClosing(WindowEvent e){
	d1.dispose();
	}});

	fm_c.addActionListener(new ActionListener(){@Override
	public void actionPerformed(ActionEvent e){
	d1.setVisible(true);
	tf24.setText("Creator is cool, Isn't it;-)");
	}});
	d1.pack();
///////////////////////////////////////////software info//////////////////////////////////////
	Dialog dd1 = new Dialog(this, "Software Info", true);
	dd1.setLayout( new GridLayout(0,1,0,1) );
	dd1.setBackground(Color.darkGray);

	Label lll= new Label("EncryptVibes");
	lll.setForeground(Color.white);
	lll.setBackground(Color.darkGray);
	lll.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
	dd1.add(lll);

	Label lle= new Label("The future resides here");
	lle.setForeground(Color.red);
	lle.setBackground(Color.darkGray);
	lle.setFont(new Font("TimesNewRoman", Font.ITALIC, 12));
	dd1.add(lle);

	Label llw= new Label("                           ");
	llw.setForeground(Color.white);
	llw.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	llw.setBackground(Color.darkGray);
	dd1.add(llw);

	Label llf= new Label("Version: 1.3.1");
	llf.setForeground(Color.orange);
	llf.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	llf.setBackground(Color.darkGray);
	dd1.add(llf);

	Label llo= new Label("EncryptVibbes is a user friendly Text Editor");
	llo.setForeground(Color.white);
	llo.setBackground(Color.black);
	llo.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	dd1.add(llo);

	Label llp= new Label(" with Networking and encryption Techniques");
	llp.setBackground(Color.black);
	llp.setForeground(Color.white);
	llp.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	dd1.add(llp);

	Label llq= new Label("completely Based on java awt");
	llq.setForeground(Color.white);
	llq.setBackground(Color.black);
	llq.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	dd1.add(llq);
	dd1.addWindowListener(new WindowAdapter(){
	public void windowClosing(WindowEvent e){
	dd1.dispose();
	}});
	dd1.setSize(300,300);
	dd1.pack();
	dd1.setLocation(320, 170);

	MenuItem fm_s = new MenuItem("Software Info");
	fm_s.setShortcut(new MenuShortcut(KeyEvent.VK_F2));
	AboutMenu.add(fm_c);
	AboutMenu.add(fm_s);
	fm_s.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	dd1.setVisible(true);
	tf24.setText("SoftWare Infos , Wait for Exciting feature, in the mere future");
	}});
	menuBar.add(AboutMenu);
	setMenuBar(menuBar);
	setBackground(Color.white);
	setVisible(true);

////////////////////////////////////////////panel p2 in north//////////////////////////////////
	p2 = new Panel();
	Label b2 = new Label("");
	b2.setSize(200, 100);
	b2.setForeground(Color.red);
	b2.setBackground(Color.black);

////////////////////////////////////////////////date////////////////////////////////////////////
        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new TimerTask()
	 {
            @Override
            public void run()
	    {
            String string = new SimpleDateFormat("E   dd/MM/yyyy" ).format(new Date());
                b2.setText(string);
            }
        }, 0, 1000);

//////////////////////////////////////////////Time////////////////////////////////////////////////

	Label label = new Label("");
	label.setSize(200, 100);

	label.setForeground(Color.green);
	label.setBackground(Color.black);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
	 {
            @Override
            public void run() {
                String string = new SimpleDateFormat("HH:mm:ss").format(new Date());
                label.setText(string);
            }
        }, 0, 1000);

	Button b5 = new Button("Encrypt Document");
	b5.setForeground(Color.white);
	b5.setBackground(Color.black);

////////////////////////////////////////////////encryption////////////////////////////////////
	b5.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Hey This is Viginere Encryption!! Safer to use and Quite Hard to be decrypted:-}");if(iter)
	key=mass;
	String netkey="";
	String code=ta2.getText();
	int t=code.length();
	int x=key.length();
	int z=t/x+1;
	for(int i=0;i<z;i++)netkey+=key;
        char[] re= new char[t];
	char[] ch=code.toCharArray();
	char[] keyi=netkey.toCharArray();
	for(int i=0;i<t;i++)
	{   re[i]=ch[i];
	if(Character.isLetter(ch[i]))
	{
		if(Character.isUpperCase(ch[i]))
		{
		int y=(char)keyi[i]+(char)ch[i]-96;
		if(y>90)
		{
		y=y-26;
		}
		re[i]=(char)y;
		}
		else if(Character.isLowerCase(ch[i]))
		{
			int y=(char)keyi[i]+(char)ch[i]-96;
			if(y>122)
		{y=y-26;
		}
			re[i]=(char)y;
		}
	}
	else if(Character.isDigit(ch[i]))
	{
	int y=9-ch[i]+48;
	re[i]=Character.forDigit(y,12);
	}
		else if(ch[i]==' ')
	{re[i]='`';
	}
		else if(ch[i]=='`')
	{re[i]=' ';
	}
		else if(ch[i]=='$')
	{re[i]='@';
	}
		else if(ch[i]=='@')
	{re[i]='$';
	}
		else if(ch[i]=='{')
	{re[i]='[';
	}
		else if(ch[i]=='[')
	{re[i]='(';
	}
		else if(ch[i]=='(')
	{re[i]='{';
	}
		else if(ch[i]=='}')
	{re[i]=']';
	}
		else if(ch[i]==']')
	{re[i]=')';
	}
		else if(ch[i]==')')
	{re[i]='}';
	}
		else if(ch[i]=='&')
	{re[i]='|';
	}
		else if(ch[i]=='|')
	{re[i]='&';
	}
		else if(ch[i]=='>')
	{re[i]='<';
	}
		else if(ch[i]=='<')
	{re[i]='>';
	}
		else if(ch[i]=='.')
	{re[i]=',';
	}
		else if(ch[i]==',')
	{re[i]='?';
	}
		else if(ch[i]=='?')
	{re[i]='.';
	}
		else if(ch[i]=='+')
	{re[i]='-';
	}
		else if(ch[i]=='-')
	{re[i]='/';
	}
		else if(ch[i]=='/')
	{re[i]='*';
	}
		else if(ch[i]=='*')
	{re[i]='+';
	}
		else if(ch[i]=='=')
	{re[i]=';';
	}
		else if(ch[i]==';')
	{re[i]='"';
	}
		else if(ch[i]=='"')
	{re[i]='#';
	}
		else if(ch[i]=='#')
	{re[i]='%';
	}
		else if(ch[i]=='%')
	{re[i]='^';
	}
		else if(ch[i]=='^')
	{re[i]=':';
	}
		else if(ch[i]==':')
	{re[i]='~';
	}
		else if(ch[i]=='~')
	{re[i]='=';
	}
	}
	String ter1="";
	for(int i=0;i<t;i++)
	ter1+=re[i];
	ta2.setText(ter1);
        }});
	Button b7 = new Button("Decrypt Document");
	b7.setForeground(Color.white);
	b7.setBackground(Color.black);
///////////////////////////////////////////////////decryption///////////////////////////
	b7.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
	String netkey="";
	String decode=ta2.getText();;
	tf24.setText("Hola, Your text is decrypted!! Enjoy -Read the message ");
	int t=decode.length();
	if(iter)
	key=mass;
	int x=key.length();
	int z=t/x+1;
	for(int i=0;i<z;i++)netkey+=key;
        char[] de= new char[t];
	char[] ch=decode.toCharArray();
	char[] keyi=netkey.toCharArray();
	for(int i=0;i<t;i++)
	{   de[i]=ch[i];

	if(Character.isLetter(ch[i]))
	{
		if(Character.isUpperCase(ch[i]))
		{
		int y=-(char)keyi[i]+(char)ch[i]+96;

		if(y<65)
		{y=y+26;
		}
		de[i]=(char)y;
		}
		else if(Character.isLowerCase(ch[i]))
		{
			int y=-(char)keyi[i]+(char)ch[i]+96;
		if(y<97)
		{y=y+26;
		}
			de[i]=(char)y;
		}
	}
	else if(Character.isDigit(ch[i]))
	{
	int y=9-ch[i]+48;
	de[i]=Character.forDigit(y,12);
	}
	else if(ch[i]=='`')
	{de[i]=' ';
	}
		else if(ch[i]==' ')
	{de[i]='`';
	}
		else if(ch[i]=='$')
	{de[i]='@';
	}
		else if(ch[i]=='@')
	{de[i]='$';
	}
		else if(ch[i]=='{')
	{de[i]='(';
	}
		else if(ch[i]=='[')
	{de[i]='{';
	}
		else if(ch[i]=='(')
	{de[i]='[';
	}
		else if(ch[i]=='}')
	{de[i]=')';
	}
		else if(ch[i]==']')
	{de[i]='}';
	}
		else if(ch[i]==')')
	{de[i]=']';
	}
		else if(ch[i]=='&')
	{de[i]='|';
	}
		else if(ch[i]=='|')
	{de[i]='&';
	}
		else if(ch[i]=='>')
	{de[i]='<';
	}
		else if(ch[i]=='<')
	{de[i]='>';
	}
		else if(ch[i]=='.')
	{de[i]='?';
	}
		else if(ch[i]==',')
	{de[i]='.';
	}
		else if(ch[i]=='?')
	{de[i]=',';
	}
		else if(ch[i]=='+')
	{de[i]='*';
	}
		else if(ch[i]=='-')
	{de[i]='+';
	}
		else if(ch[i]=='/')
	{de[i]='-';
	}
		else if(ch[i]=='*')
	{de[i]='/';
	}
		else if(ch[i]=='=')
	{de[i]='~';
	}
		else if(ch[i]==';')
	{de[i]='=';
	}
		else if(ch[i]=='"')
	{de[i]=';';
	}
		else if(ch[i]=='#')
	{de[i]='"';
	}
		else if(ch[i]=='%')
	{de[i]='#';
	}
		else if(ch[i]=='^')
	{de[i]='%';
	}
		else if(ch[i]==':')
	{de[i]='^';
	}
	}
	String ter="";
	for(int i=0;i<t;i++)ter+=de[i];
	ta2.setText(ter);
	}});


///////////////////////////////////////////Save button////////////////////////////////////
	Button b6 = new Button("Save");
	b6.setForeground(Color.white);
	b6.setBackground(Color.black);
	b6.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent ae){
	String txt=ta2.getText();
	fd.setVisible(true);
	try{
	String dir=fd.getDirectory();
        String fname=fd.getFile();
	FileOutputStream file=new FileOutputStream(dir+fname);
	DataOutputStream dos=new DataOutputStream(file);
                dos.writeBytes(txt);
                dos.close();
	}
	catch(Exception e){}
	}});

	Panel p5=new Panel();
	p5.add(b2);
	p5.add(label);
	p5.add(b5);
	p5.add(b7);
	p5.add(b6);
	p5.setBackground(Color.black);

	Button tew = new Button("Recieve Mode");
	tew.setForeground(Color.white);
	tew.setBackground(Color.black);
	tew.setFont(new Font("Verdana", Font.BOLD, 12));
	tew.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("Save the file as recieving data may ovrwrite the existing data");
	d6.setVisible(true);
	}});

	Button tew1 = new Button("Send");
	tew1.setForeground(Color.white);
	tew1.setBackground(Color.black);
	tew1.setFont(new Font("Verdana", Font.BOLD, 12));
	tew1.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	try{
	DatagramSocket serversocket;
	DatagramPacket dp;
	BufferedReader dis;
	InetAddress ia;
	byte buf[] = new byte[12345];
	int cport = 11789, sport = 11790;
	tf24.setText("The Document text is send over to the network, Reciever should be set in Reciever Mode to recieve");
	serversocket = new DatagramSocket(cport);
	dp = new DatagramPacket(buf, buf.length);
	dis = new BufferedReader(new InputStreamReader(System.in));
	ia = InetAddress.getLocalHost();
	String str = new String(ta2.getText());
	buf = str.getBytes();
	serversocket.send(new DatagramPacket(buf,str.length(), ia, sport));
	serversocket.close();
	}
	catch(Exception ae){}

	}});
	Button b161 = new Button(" + ");
	b161.addActionListener(new ActionListener(){@Override
	public void actionPerformed(ActionEvent e){
	ta2.setFont(new Font(ta2.getFont().getName(), ta2.getFont().getStyle(), ta2.getFont().getSize()+1));
	tf24.setText("Text Size is Increased");
	}});
	b161.setForeground(Color.cyan);
	b161.setBackground(Color.black);
	b161.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
	Button b162 = new Button(" - ");
	b162.addActionListener(new ActionListener(){@Override
	public void actionPerformed(ActionEvent e){
	ta2.setFont(new Font(ta2.getFont().getName(), ta2.getFont().getStyle(), ta2.getFont().getSize()-1));
	tf24.setText("Text Size is Decreased");
	}});
	Label b351 = new Label("        ");
	b162.setForeground(Color.cyan);
	b162.setBackground(Color.black);
	b162.setFont(new Font("TimesNewRoman", Font.BOLD, 21));
	Panel p3=new Panel();
	p3.setBackground(Color.black);
	Label b35 = new Label("Search:");
	p3.add(b162);
	p3.add(b161);
	p3.add(b351);
	b35.setForeground(Color.white);
	b35.setBackground(Color.black);
	p3.add(tew1);
	p3.add(tew);
	p3.add(b35);


////////////////////////////////////////////Searchfield//////////////////////////////////
	TextField tf4 = new TextField(16);
	tf4.setForeground(Color.black);
	tf4.setBackground(Color.white);
	tf4.setFont(new Font("Verdana", Font.BOLD, 12));

////////////////////////////////////////Code for kmp/////////////////////////////////
	tf4.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent eve){
	tf24.setText("Press Enter to set the text to be searched");
	bool=true;
	String txt = ta2.getText();
        String Find =tf4.getText();
	int M = Find.length();
        int N = txt.length();
        int long_ps[] = new int[M];
        int j = 0;
        int len = 0;
        int i = 1;
        long_ps[0] = 0;
        while (i < M)
        {
            if (Find.charAt(i) == Find.charAt(len))
            {
                len++;
                long_ps[i] = len;
                i++;
            }
            else
	   {
		 if (len != 0)
                {
                    len = long_ps[len-1];
                }
                else
                {
                    long_ps[i] = len;
                    i++;
                }
            }
        }
        i = 0;
        while (i < N)
        {
            if (Find.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
    		if(bool)
		{
		ta2.select(i-j,i-j+Find.length());
		d66.setVisible(true);
                j = long_ps[j-1];
		}
		else
		 break;
            }

            else if (i < N && Find.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = long_ps[j-1];
                else
                    i = i+1;
            }
        }
	}});

	p3.add(tf4);

	bbb = new Label("00:00:00");
	bbb.setForeground(Color.orange);
	bbb.setBackground(Color.black);
	bbb.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
	Button b16 = new Button("@");
	b16.setForeground(Color.yellow);
	b16.setBackground(Color.black);
	b16.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	tf24.setText("SoftWare Infos , Wait for Exciting feature, in the mere future");
	dd1.setVisible(true);
	}});
	p3.add(b16);
	p2.setLayout(new BorderLayout(5,2));
	p2.setSize(100, 5000);
	p2.setBackground(Color.black);
	p2.setForeground(Color.white);
	p2.add(bbb,BorderLayout.CENTER);
	p2.add(p5,BorderLayout.WEST);
	p2.add(p3,BorderLayout.EAST);
	add(p2, BorderLayout.NORTH);

////////////////////////////////////////popup menu//////////////////////////////
	popMenu = new PopupMenu("");

	MenuItem pm_cut = new MenuItem("Cut");
	pm_cut.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	message=ta2.getSelectedText();
        ta2.replaceRange("",ta2.getSelectionStart(),ta2.getSelectionEnd());
	StringSelection stringSelection = new StringSelection(message);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	clpbrd.setContents(stringSelection, null);
	}
	});

///////////////////////////copy//////////////////////////////////

	MenuItem pm_copy = new MenuItem("Copy");
	pm_copy.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	message=ta2.getSelectedText();
	StringSelection stringSelection = new StringSelection(message);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	clpbrd.setContents(stringSelection, null);
	tf24.setText("The Text is copied and ready to be pasted at desired Location;-)");
	}
	});
	MenuItem pm_paste = new MenuItem("Paste");
	pm_paste.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	 Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	try{
	message=(String)clpbrd.getData(DataFlavor.stringFlavor);
	ta2.replaceRange(message,ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("The required Text is pasted ;-)");
	}catch(Exception ex){}
	}
	});
	MenuItem pm_delete = new MenuItem("Delete");
	pm_delete.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	ta2.replaceRange("",ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("Deleted the selected text");
	}
	});
	MenuItem pm_encrypt = new MenuItem("Encrypt Selected");
	pm_encrypt.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	tf24.setText("Hey This is Viginere Encryption!! Safer to use and Quite Hard to be decrypted:-}");
	if(iter)
	key=mass;
	String netkey="";
	String code=ta2.getSelectedText();
	int t=code.length();
	int x=key.length();
	int z=t/x+1;
	for(int i=0;i<z;i++)netkey+=key;
        char[] re= new char[t];
	char[] ch=code.toCharArray();
	char[] keyi=netkey.toCharArray();
	for(int i=0;i<t;i++)
	{   re[i]=ch[i];
	if(Character.isLetter(ch[i]))
	{
		if(Character.isUpperCase(ch[i]))
		{
		int y=(char)keyi[i]+(char)ch[i]-96;
		if(y>90)
		{y=y-26;
		}
		re[i]=(char)y;
		}
		else if(Character.isLowerCase(ch[i]))
		{
			int y=(char)keyi[i]+(char)ch[i]-96;
			if(y>122)
		{y=y-26;
		}
			re[i]=(char)y;
		}
	}
	else if(Character.isDigit(ch[i]))
	{
	int y=9-ch[i]+48;
	re[i]=Character.forDigit(y,12);
	}
		else if(ch[i]==' ')
	{
	re[i]='`';
	}
		else if(ch[i]=='`')
	{re[i]=' ';
	}
		else if(ch[i]=='$')
	{re[i]='@';
	}
		else if(ch[i]=='@')
	{re[i]='$';
	}
		else if(ch[i]=='{')
	{re[i]='[';
	}
		else if(ch[i]=='[')
	{re[i]='(';
	}
		else if(ch[i]=='(')
	{re[i]='{';
	}
		else if(ch[i]=='}')
	{re[i]=']';
	}
		else if(ch[i]==']')
	{re[i]=')';
	}
		else if(ch[i]==')')
	{re[i]='}';
	}
		else if(ch[i]=='&')
	{re[i]='|';
	}
		else if(ch[i]=='|')
	{re[i]='&';
	}
		else if(ch[i]=='>')
	{re[i]='<';
	}
		else if(ch[i]=='<')
	{re[i]='>';
	}
		else if(ch[i]=='.')
	{re[i]=',';
	}
		else if(ch[i]==',')
	{re[i]='?';
	}
		else if(ch[i]=='?')
	{re[i]='.';
	}
		else if(ch[i]=='+')
	{re[i]='-';
	}
		else if(ch[i]=='-')
	{re[i]='/';
	}
		else if(ch[i]=='/')
	{re[i]='*';
	}
		else if(ch[i]=='*')
	{re[i]='+';
	}
		else if(ch[i]=='=')
	{re[i]=';';
	}
		else if(ch[i]==';')
	{re[i]='"';
	}
		else if(ch[i]=='"')
	{re[i]='#';
	}
		else if(ch[i]=='#')
	{re[i]='%';
	}
		else if(ch[i]=='%')
	{re[i]='^';
	}
		else if(ch[i]=='^')
	{re[i]=':';
	}
		else if(ch[i]==':')
	{re[i]='~';
	}
		else if(ch[i]=='~')
	{re[i]='=';
	}
	}
	String ter1="";
	for(int i=0;i<t;i++)ter1+=re[i];
	ta2.replaceRange(ter1,ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("The Selected Text in the Document is Encrypted");
	}
	});
	MenuItem pm_decrypt = new MenuItem("Decrypt Selected");
	pm_decrypt.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	if(iter)
	key=mass;
	String netkey="";
	String decode=ta2.getSelectedText();;

	int t=decode.length();
	int x=key.length();
	int z=t/x+1;
	for(int i=0;i<z;i++)netkey+=key;
        char[] de= new char[t];
	char[] ch=decode.toCharArray();
	char[] keyi=netkey.toCharArray();
	for(int i=0;i<t;i++)
	{
	de[i]=ch[i];
	if(Character.isLetter(ch[i]))
	{
		if(Character.isUpperCase(ch[i]))
		{
		int y=-(char)keyi[i]+(char)ch[i]+96;
		if(y<65)
		{
			y=y+26;
		}
		de[i]=(char)y;
		}
		else if(Character.isLowerCase(ch[i]))
		{
			int y=-(char)keyi[i]+(char)ch[i]+96;

			if(y<97)
		{y=y+26;
		}
			de[i]=(char)y;
		}
	}
	else if(Character.isDigit(ch[i]))
	{
	int y=9-ch[i]+48;
	de[i]=Character.forDigit(y,12);
	}
	else if(ch[i]=='`')
	{de[i]=' ';
	}
		else if(ch[i]==' ')
	{de[i]='`';
	}
		else if(ch[i]=='$')
	{de[i]='@';
	}
		else if(ch[i]=='@')
	{de[i]='$';
	}
		else if(ch[i]=='{')
	{de[i]='(';
	}
		else if(ch[i]=='[')
	{de[i]='{';
	}
		else if(ch[i]=='(')
	{de[i]='[';
	}
		else if(ch[i]=='}')
	{de[i]=')';
	}
		else if(ch[i]==']')
	{de[i]='}';
	}
		else if(ch[i]==')')
	{de[i]=']';
	}
		else if(ch[i]=='&')
	{de[i]='|';
	}
		else if(ch[i]=='|')
	{de[i]='&';
	}
		else if(ch[i]=='>')
	{de[i]='<';
	}
		else if(ch[i]=='<')
	{de[i]='>';
	}
		else if(ch[i]=='.')
	{de[i]='?';
	}
		else if(ch[i]==',')
	{de[i]='.';
	}
		else if(ch[i]=='?')
	{de[i]=',';
	}
		else if(ch[i]=='+')
	{de[i]='*';
	}
		else if(ch[i]=='-')
	{de[i]='+';
	}
		else if(ch[i]=='/')
	{de[i]='-';
	}
		else if(ch[i]=='*')
	{de[i]='/';
	}
		else if(ch[i]=='=')
	{de[i]='~';
	}
		else if(ch[i]==';')
	{de[i]='=';
	}
		else if(ch[i]=='"')
	{de[i]=';';
	}
		else if(ch[i]=='#')
	{de[i]='"';
	}
		else if(ch[i]=='%')
	{de[i]='#';
	}
		else if(ch[i]=='^')
	{de[i]='%';
	}
		else if(ch[i]==':')
	{de[i]='^';
	}
	}
	String ter="";
	for(int i=0;i<t;i++)
	ter+=de[i];
	ta2.replaceRange(ter,ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("The Selected Text is Decrypted :-)");
	}
	});
	MenuItem pm_selectall = new MenuItem("Select all            ");
	pm_selectall.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae)
	{
	ta2.selectAll();
	tf24.setText("Entire Text is Selected in the document");
	}
	});
	MenuItem pm_date = new MenuItem("Present Date");
	pm_date.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	String string = new SimpleDateFormat(" dd/MM/yyyy" ).format(new Date());
 	ta2.replaceRange(string,ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("Today's Date is copied over to document");
	}});

	MenuItem pm_time = new MenuItem("Present Time");
	pm_time.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	String string = new SimpleDateFormat(" hh:mm:ss a" ).format(new Date());
 	ta2.replaceRange(string,ta2.getSelectionStart(),ta2.getSelectionEnd());
	tf24.setText("Present Time is inserted to the Document");
	}});
	popMenu.add(pm_cut);
	popMenu.add(pm_copy);
	popMenu.add(pm_paste);
	popMenu.add(pm_delete);
	popMenu.add(pm_date);
	popMenu.add(pm_time);
	popMenu.add(pm_encrypt);
	popMenu.add(pm_decrypt);
	popMenu.add(pm_selectall);
	popMenu.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
	add(popMenu);

//////////////////////////////////////////Textfield//////////////////////////////////////
	ta2= new TextArea("",35, 136, TextArea.SCROLLBARS_BOTH);
	ta2.setFont(new Font("TimesNewRoman", Font.PLAIN, 14));
	ta2.addKeyListener(this);
	ta2.addMouseListener(this);
	ta2.setForeground(Color.black);
	ta2.setBackground(Color.white);
	add(ta2,BorderLayout.CENTER);

	p1 = new Panel();
	p1.setBackground(Color.darkGray);
	p1.setLayout(new GridLayout());
	p1.setSize(200, 5000);
	b12 = new Label("Words:     ");
		b12.setSize(400, 100);
		b12.setForeground(Color.red);
		b12.setBackground(Color.black);
	p1.add(b12);
	b13 = new Label("Characters:     ");
		b13.setSize(200, 100);
		b13.setForeground(Color.green);
		b13.setBackground(Color.black);

	p1.add(b13);
	b36 = new Label("Total Lines:     ");
		b36.setSize(200, 100);
		b36.setForeground(Color.yellow);
		b36.setBackground(Color.black);
	p1.add(b36);
	b32 = new Label("Last Typed:     ");
		b32.setSize(200, 100);
		b32.setForeground(Color.white);
		b32.setBackground(Color.black);
	p1.add(b32);

	tf24 = new Label();
	tf24.setForeground(Color.cyan);
	tf24.setBackground(Color.black);
	tf24.setFont(new Font("Verdana", Font.BOLD, 12));
	tf24.setText("Hi!! I am Quotext, welcomes you to \"-EncryptVibes-\" ,Encryptable Transferable user Friendly Notepad, Lets begin the journey!!");

	Panel ps1 = new Panel();
	ps1.setLayout( new GridLayout(0,1,0,1) );
	ps1.setBackground(Color.black);
	ps1.add(tf24);
	ps1.add(p1);
	add(ps1, BorderLayout.SOUTH);

///////////////////////////////////exit Dialog/////////////////////////////////////////
	d2=new Dialog(this,"Exit",true);
        d2.setLayout( new GridLayout(0,1,0,1) );
        d2.setBackground(Color.black);
	d2.setForeground(Color.white);
        Label lbl_show_msg=new Label("      Do you want to save before exit ??      ");
        d2.add(lbl_show_msg);


	lbl_show_msg.setFont(new Font("TimesNewRoman", Font.PLAIN, 16));
        Panel pr=new Panel();
	Label lbli=new Label("                                 ");
        lbli.setBackground(Color.black);
	d2.add(lbli);
	Label lblii=new Label("                                 ");
        lblii.setBackground(Color.black);
	d2.add(lblii);

        Button btn_yes=new Button("Don't Save,Exit  ");
	btn_yes.setFont(new Font("TimesNewRoman", Font.PLAIN,12));

	btn_yes.setForeground(Color.black);
	pr.setBackground(Color.white);
	btn_yes.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
        dispose();System.exit(0);
         }
  	});

	Button btn_can=new Button("  Save and exit ");
	btn_can.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        pr.add(btn_can);
	pr.add(btn_yes);
	btn_can.setForeground(Color.black);
	btn_can.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent ae){
	tf24.setText("Save your file, Wish we will meet again Later ;-)");
	String txt=ta2.getText();
	fd.setVisible(true);
	try{
	String dir=fd.getDirectory();
        String fname=fd.getFile();
	FileOutputStream file=new FileOutputStream(dir+fname);
	DataOutputStream dos=new DataOutputStream(file);
        dos.writeBytes(txt);
        dos.close();
	}
	catch(Exception e){}
        dispose();System.exit(0);
         }
  	});

        Button btn_no=new Button("   Cancel  ");
	btn_no.setForeground(Color.black);
        btn_no.addActionListener(this);
        pr.add(btn_no);
	btn_no.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
        btn_no.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
        tf24.setText("Hey , Catched u again ;-}");
	d2.dispose();
        }
	});
	d2.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d2.dispose();
	}
	});
        d2.setTitle("Exit Window");
        d2.setSize(150,100);
	d2.setLocation(200,200);
	pr.setLayout(new GridLayout(1,0,1,0));
	d2.add(pr, BorderLayout.SOUTH);
	d2.pack();
	d66 = new Dialog(this, "Find", true);
	d66.setBackground(Color.black);
	d66.setLayout( new GridLayout(0,1,0,1) );
	b19 = new Button(" Next ");
	b19.setForeground(Color.black);
	b19.setFont(new Font("Verdana", Font.BOLD, 14));
	b19.setBackground(Color.white);
	Label l55= new Label("- The search result -");
	l55.setForeground(Color.white);
	l55.setBackground(Color.black);
	l55.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d66.add(l55);
	Label l551= new Label("                         ");
	l551.setForeground(Color.white);
	l551.setBackground(Color.black);
	l551.setFont(new Font("TimesNewRoman", Font.PLAIN, 12));
	d66.add(l551);
	b19.addActionListener(new ActionListener()
	{
	@Override
	public void actionPerformed(ActionEvent e){
   	d66.dispose();
        }});
	b19.addKeyListener(this);
	d66.add(b19, BorderLayout.SOUTH);
	d66.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        d66.dispose();
	bool=false;
	}
	});
	d66.setTitle("Search Result");
        d66.setSize(150,100);
	d66.setLocation(1000,100);
	d66.pack();
	pack();
	setBackground(SystemColor.control);
	setVisible(true);
	}

/////////////////////////////////////main/////////////////////////////////////////////
	public static void main(String args[])
	{
	EncryptVibes entv=new EncryptVibes();
	}

/////////////////////////////////////keypressed/////////////////////////////////////////
	public void keyPressed(KeyEvent e) {
	stext = e.getKeyModifiersText(e.getModifiers()) + " " +
 KeyEvent.getKeyText(e.getKeyCode());
	int s=ta2.getText().split("\\s+").length;
	int q=ta2.getText().split("\n").length;
	int c=ta2.getText().length()+1;
	tf24.setText("All The Best for Your Task!! ;-)");
	b12.setText("Words: "+s);
	b13.setText("Characters: "+c);
	b36.setText("Total Lines: "+q);

	if(e.getSource()==tf41)
	{
	if(e.getKeyCode() == KeyEvent.VK_ENTER)
	{
	if (set)
   	d661.dispose();
	if (iter)
   	d121.dispose();
        }
	}
	if(e.getSource()==txtf)
	{
	if(e.getKeyCode() == KeyEvent.VK_ENTER)
	{

	dd2.dispose();
        }
	}
	if(e.getSource()==ta2)
	{
	if(e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET && e.getModifiers()==InputEvent.CTRL_MASK)
	{ta2.setFont(new Font(ta2.getFont().getName(), ta2.getFont().getStyle(), ta2.getFont().getSize()+1));
	tf24.setText("Text Size is Increased");
	}
	if(e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET && e.getModifiers()==InputEvent.CTRL_MASK)
	{ta2.setFont(new Font(ta2.getFont().getName(), ta2.getFont().getStyle(), ta2.getFont().getSize()-1));
	tf24.setText("Text Size is Decreased");
	}
	}
	if(e.getSource()==tffff)
	{
	if(e.getKeyCode() == KeyEvent.VK_ENTER)
	{
	if (fal)
	d77.dispose();
        }
	}
	};

///////////////////////////////////keytyped/////////////////////////////////////////////////
	public void keyTyped(KeyEvent e){
	b32.setText("Last Typed: " + stext);
	if(e.getSource()==b27)
	{
	d661.dispose();
	}
	if(e.getSource()==b19)
	{
	d66.dispose();
	}
	};

//////////////////////////WindowListener Interface//////////////////////////////////////////
	public void windowClosing(WindowEvent e) {
	tf24.setText("Wish u had a Happy journey, Hereby Quotext Thanks you and wish you a happy day bbye, ;-)");
	d2.setVisible(true);
	}
	public void mouseClicked(MouseEvent me) {
	if(me.getModifiers()==InputEvent.BUTTON3_MASK)
	{
	popMenu.show(me.getComponent(),me.getX(),me.getY());
	tf24.setText("Chooose the Option");
	}
	}
	public void mouseEntered(MouseEvent me) {}
	public void mouseExited(MouseEvent me) {}
	public void mousePressed(MouseEvent me) {}
	public void mouseReleased(MouseEvent me) {}
	public void keyReleased(KeyEvent e) {}
	public void actionPerformed(ActionEvent e){}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
}

