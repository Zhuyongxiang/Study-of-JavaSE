package yy;

import java.awt.*;  
import java.awt.event.*;  
import java.text.*;  
import java.util.*;  
import java.io.*;  
import javax.swing.undo.*;  
import javax.swing.border.*;  
import javax.swing.*;  
import javax.swing.text.*;  
import javax.swing.event.*;  
import java.awt.datatransfer.*;  
 
public class Notepad extends JFrame implements ActionListener,DocumentListener  
{   //菜单
   JMenu fileMenu,editMenu,formatMenu;//JMenu构造一个菜单   
   //右键弹出菜单项
   JPopupMenu popupMenu;//JPopupMenu弹出式菜单  
   JMenuItem popupMenu_Undo,popupMenu_Cut,popupMenu_Copy,popupMenu_Paste,popupMenu_Delete,popupMenu_SelectAll;  //“文件”的菜单项  
   //JMenuItem构造菜单项
   //“文件”的菜单项  
   JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_Exit;
   //“编辑”的菜单项  
   JMenuItem editMenu_Undo,editMenu_Cut,editMenu_Copy,editMenu_Paste,editMenu_Delete,editMenu_search,editMenu_SelectAll,editMenu_TimeDate;  
   //“文本”编辑区域  
   JTextArea editArea;  
   //状态栏标签  
   JLabel statusLabel;//JLabel显示文本、图像  
   
   JTextArea myarea=new JTextArea();
   int start=0;//查找开始位置
   int end=0;//查找结束位置

   
   //系统剪贴板  
   Toolkit toolkit=Toolkit.getDefaultToolkit();//工具包  
   Clipboard clipBoard=toolkit.getSystemClipboard();//提取或替换剪贴版文本内容  
   //创建撤销操作管理器(与撤销操作有关)  
   protected UndoManager undo=new UndoManager();  
   protected UndoableEditListener undoHandler=new UndoHandler();  
   //其他变量  
   String oldValue;//存放编辑区原来的内容，用于比较文本是否有改动  
   boolean isNewFile=true;//是否新文件(未保存过的)  
   File currentFile;//当前文件名  
   //构造函数开始  
   public Notepad()  
   {     
       super("Java记事本");  
       //改变系统默认字体  
       Font font = new Font("Dialog", Font.PLAIN, 12);  
       java.util.Enumeration keys = UIManager.getDefaults().keys();  
       while (keys.hasMoreElements()) {  
           Object key = keys.nextElement();  
           Object value = UIManager.get(key);  
           if (value instanceof javax.swing.plaf.FontUIResource) {  
               UIManager.put(key, font);  
           }  
       }  
       //创建菜单条  
       JMenuBar menuBar=new JMenuBar();  
       //创建文件菜单及菜单项并注册事件监听  
       fileMenu=new JMenu("文件(F)");  
       fileMenu.setMnemonic('F');//设置快捷键ALT+F  
 
       fileMenu_New=new JMenuItem("新建(N)");  
       fileMenu_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));  
       fileMenu_New.addActionListener(this);  
 
       fileMenu_Open=new JMenuItem("打开(O)...");  
       fileMenu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));  
       fileMenu_Open.addActionListener(this);  
 
       fileMenu_Save=new JMenuItem("保存(S)");  
       fileMenu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));  
       fileMenu_Save.addActionListener(this);  
 
       fileMenu_SaveAs=new JMenuItem("另存为(A)...");  
       fileMenu_SaveAs.addActionListener(this);  
 
 
       fileMenu_Exit=new JMenuItem("退出(X)");  
       fileMenu_Exit.addActionListener(this);  
 
       //创建编辑菜单及菜单项并注册事件监听  
       editMenu=new JMenu("编辑(E)");  
       editMenu.setMnemonic('E');//设置快捷键ALT+E  
       //当选择编辑菜单时，设置剪切、复制、粘贴、删除等功能的可用性  
       editMenu.addMenuListener(new MenuListener()  
       {   public void menuCanceled(MenuEvent e)//取消菜单时调用  
           {   checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性  
           }  
           public void menuDeselected(MenuEvent e)//取消选择某个菜单时调用  
           {   checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性  
           }  
           public void menuSelected(MenuEvent e)//选择某个菜单时调用  
           {   checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性  
           }  
       });  
 
       editMenu_Undo=new JMenuItem("撤销(U)");  
       editMenu_Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));  
       editMenu_Undo.addActionListener(this);  
       editMenu_Undo.setEnabled(false);  
 
       editMenu_Cut=new JMenuItem("剪切(T)");  
       editMenu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));  
       editMenu_Cut.addActionListener(this);  
 
       editMenu_Copy=new JMenuItem("复制(C)");  
       editMenu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));  
       editMenu_Copy.addActionListener(this);  
 
       editMenu_Paste=new JMenuItem("粘贴(P)");  
       editMenu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));  
       editMenu_Paste.addActionListener(this);  
 
       editMenu_Delete=new JMenuItem("删除(D)");  
       editMenu_Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));  
       editMenu_Delete.addActionListener(this);  
 
       editMenu_search=new JMenuItem("查找和替换(F)...");  
       editMenu_search.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));  
       editMenu_search.addActionListener(this);  
 
 
       editMenu_SelectAll = new JMenuItem("全选",'A');   
       editMenu_SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));   
       editMenu_SelectAll.addActionListener(this);  
 
       editMenu_TimeDate = new JMenuItem("时间/日期(D)",'D');  
       editMenu_TimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));  
       editMenu_TimeDate.addActionListener(this);  
 
 
       //向菜单条添加"文件"菜单及菜单项  
       menuBar.add(fileMenu);   
       fileMenu.add(fileMenu_New);   
       fileMenu.add(fileMenu_Open);   
       fileMenu.add(fileMenu_Save);   
       fileMenu.add(fileMenu_SaveAs);   
       fileMenu.addSeparator();        //分隔线   
       fileMenu.add(fileMenu_Exit);   
 
       //向菜单条添加"编辑"菜单及菜单项   
       menuBar.add(editMenu);   
       editMenu.add(editMenu_Undo);    
       editMenu.addSeparator();        //分隔线   
       editMenu.add(editMenu_Cut);   
       editMenu.add(editMenu_Copy);   
       editMenu.add(editMenu_Paste);   
       editMenu.add(editMenu_Delete);   
       editMenu.addSeparator();        //分隔线  
       editMenu.add(editMenu_search);      
       editMenu.addSeparator();        //分隔线  
       editMenu.add(editMenu_SelectAll);   
       editMenu.add(editMenu_TimeDate);  
 
                 
       //向窗口添加菜单条                
       this.setJMenuBar(menuBar);  
 
       //创建文本编辑区并添加滚动条  
       editArea=new JTextArea(20,50);  
       JScrollPane scroller=new JScrollPane(editArea);  
       scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //竖直的滚动条
       this.add(scroller,BorderLayout.CENTER);//向窗口添加文本编辑区  
       editArea.setWrapStyleWord(true);//设置单词在一行不足容纳时换行  
       editArea.setLineWrap(true);//设置文本编辑区自动换行默认为true,即会"自动换行"  
       //this.add(editArea,BorderLayout.CENTER);//向窗口添加文本编辑区  
       oldValue=editArea.getText();//获取原文本编辑区的内容  
 
       //编辑区注册事件监听(与撤销操作有关)  
       editArea.getDocument().addUndoableEditListener(undoHandler);  
       editArea.getDocument().addDocumentListener(this);  
 
       //创建右键弹出菜单  
       popupMenu=new JPopupMenu();  
       popupMenu_Undo=new JMenuItem("撤销(U)");  
       popupMenu_Cut=new JMenuItem("剪切(T)");  
       popupMenu_Copy=new JMenuItem("复制(C)");  
       popupMenu_Paste=new JMenuItem("粘帖(P)");  
       popupMenu_Delete=new JMenuItem("删除(D)");  
       popupMenu_SelectAll=new JMenuItem("全选(A)");  
 
       popupMenu_Undo.setEnabled(false);  
 
       //向右键菜单添加菜单项和分隔符  
       popupMenu.add(popupMenu_Undo);  
       popupMenu.addSeparator();  
       popupMenu.add(popupMenu_Cut);  
       popupMenu.add(popupMenu_Copy);  
       popupMenu.add(popupMenu_Paste);  
       popupMenu.add(popupMenu_Delete);  
       popupMenu.addSeparator(); //分隔线
       popupMenu.add(popupMenu_SelectAll);  
 
       //文本编辑区注册右键菜单事件  
       popupMenu_Undo.addActionListener(this);  
       popupMenu_Cut.addActionListener(this);  
       popupMenu_Copy.addActionListener(this);  
       popupMenu_Paste.addActionListener(this);  
       popupMenu_Delete.addActionListener(this);  
       popupMenu_SelectAll.addActionListener(this);  
 
       //文本编辑区注册右键菜单事件  
       editArea.addMouseListener(new MouseAdapter()  
       {   public void mousePressed(MouseEvent e)  
           {   if(e.isPopupTrigger())//返回此鼠标事件是否为该平台的弹出菜单触发事件  
               {   popupMenu.show(e.getComponent(),e.getX(),e.getY());//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单  
               }  
               checkMenuItemEnabled();//设置剪切，复制，粘帖，删除等功能的可用性  
               editArea.requestFocus();//编辑区获取焦点  
           }  
           public void mouseReleased(MouseEvent e)  
           {   if(e.isPopupTrigger())//返回此鼠标事件是否为该平台的弹出菜单触发事件  
               {   popupMenu.show(e.getComponent(),e.getX(),e.getY());//在组件调用者的坐标空间中的位置 X、Y 显示弹出菜单  
               }  
               checkMenuItemEnabled();//设置剪切，复制，粘帖，删除等功能的可用性  
               editArea.requestFocus();//编辑区获取焦点  
           }  
       });//文本编辑区注册右键菜单事件结束  
 
 
       //设置窗口在屏幕上的位置、大小和可见性   
       this.setLocation(100,100);  
       this.setSize(650,550);  
       this.setVisible(true);  //可见度
       //添加窗口监听器  
       addWindowListener(new WindowAdapter()  
       {   public void windowClosing(WindowEvent e)  
           {   exitWindowChoose();  
           }  
       });  
 
       checkMenuItemEnabled();  
       editArea.requestFocus();  
   }//构造函数Notepad结束  
     
   //设置菜单项的可用性：剪切，复制，粘帖，删除功能  
   public void checkMenuItemEnabled()  
   {   String selectText=editArea.getSelectedText();  
       if(selectText==null)  //文本为空
       {   editMenu_Cut.setEnabled(false);  
           popupMenu_Cut.setEnabled(false);  
           editMenu_Copy.setEnabled(false);  
           popupMenu_Copy.setEnabled(false);  
           editMenu_Delete.setEnabled(false);  
           popupMenu_Delete.setEnabled(false);  
       }  
       else  
       {   editMenu_Cut.setEnabled(true);  
           popupMenu_Cut.setEnabled(true);   
           editMenu_Copy.setEnabled(true);  
           popupMenu_Copy.setEnabled(true);  
           editMenu_Delete.setEnabled(true);  
           popupMenu_Delete.setEnabled(true);  
       }  
       //粘帖功能可用性判断  
       Transferable contents=clipBoard.getContents(this);  //监听
       if(contents==null)  
       {   editMenu_Paste.setEnabled(false);  
           popupMenu_Paste.setEnabled(false);  
       }  
       else  
       {   editMenu_Paste.setEnabled(true);  
           popupMenu_Paste.setEnabled(true);     
       }  
   }//方法checkMenuItemEnabled()结束  
 
   //关闭窗口时调用  
   public void exitWindowChoose()  
   {   editArea.requestFocus();  
       String currentValue=editArea.getText();  
       if(currentValue.equals(oldValue)==true)  
       {   System.exit(0);  
       }  
       else  
       {   int exitChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","退出提示",JOptionPane.YES_NO_CANCEL_OPTION);  
           if(exitChoose==JOptionPane.YES_OPTION)  
           {   //boolean isSave=false;  
               if(isNewFile)  //判断是否为新文件
               {     
                   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   fileChooser.setApproveButtonText("确定");  
                   fileChooser.setDialogTitle("另存为");  
                     
                   int result=fileChooser.showSaveDialog(this);  
                     
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("　您没有保存文件");  
                       return;  
                   }                     
     
                   File saveFileName=fileChooser.getSelectedFile();  
                 
                   if(saveFileName==null||saveFileName.getName().equals(""))  //文件名
                   {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else   
                   {   try  
                       {   FileWriter fw=new FileWriter(saveFileName);  
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           bfw.flush();  
                           fw.close();  
                             
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                             
                           this.setTitle(saveFileName.getName()+"  - 记事本");  
                           statusLabel.setText("　当前打开文件:"+saveFileName.getAbsoluteFile());  
                           //isSave=true;  
                       }                             
                       catch(IOException ioException){                   
                       }                 
                   }  
               }  
               else  
               {  
                   try  
                   {   FileWriter fw=new FileWriter(currentFile);  
                       BufferedWriter bfw=new BufferedWriter(fw);  
                       bfw.write(editArea.getText(),0,editArea.getText().length());  
                       bfw.flush();  
                       fw.close();  
                       //isSave=true;  
                   }                             
                   catch(IOException ioException){                   
                   }  
               }  
               System.exit(0);  
               //if(isSave)System.exit(0);  
               //else return;  
           }  
           else if(exitChoose==JOptionPane.NO_OPTION)  
           {   System.exit(0);  
           }  
           else  
           {   return;  
           }  
       }
   }
   //关闭窗口时调用方法结束  
 
 
   //public void menuPerformed(MenuEvent e)  
   //{ checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性  
   //}  
 
   public void actionPerformed(ActionEvent e)  
   {   //新建  
       if(e.getSource()==fileMenu_New)  
       {   editArea.requestFocus();  
           String currentValue=editArea.getText();  
           boolean isTextChange=(currentValue.equals(oldValue))?false:true;  
           if(isTextChange)  
           {   int saveChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","提示",JOptionPane.YES_NO_CANCEL_OPTION);  
               if(saveChoose==JOptionPane.YES_OPTION)  
               {   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //fileChooser.setApproveButtonText("确定");  
                   fileChooser.setDialogTitle("另存为");  
                   int result=fileChooser.showSaveDialog(this);  
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("您没有选择任何文件");  
                       return;  
                   }  
                   File saveFileName=fileChooser.getSelectedFile();  
                   if(saveFileName==null || saveFileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else   
                   {   try  
                       {   FileWriter fw=new FileWriter(saveFileName);  
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           bfw.flush();//刷新该流的缓冲  
                           bfw.close();  
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                           this.setTitle(saveFileName.getName()+" - 记事本");  
                           statusLabel.setText("当前打开文件："+saveFileName.getAbsoluteFile());  
                       }  
                       catch (IOException ioException)  
                       {  
                       }  
                   }  
               }  
               else if(saveChoose==JOptionPane.NO_OPTION)  
               {   editArea.replaceRange("",0,editArea.getText().length());  
                   statusLabel.setText(" 新建文件");  
                   this.setTitle("无标题 - 记事本");  
                   isNewFile=true;  
                   undo.discardAllEdits(); //撤消所有的"撤消"操作  
                   editMenu_Undo.setEnabled(false);  
                   oldValue=editArea.getText();  
               }  
               else if(saveChoose==JOptionPane.CANCEL_OPTION)  
               {   return;  
               }  
           }  
           else  
           {   editArea.replaceRange("",0,editArea.getText().length());  
               statusLabel.setText(" 新建文件");  
               this.setTitle("无标题 - 记事本");  
               isNewFile=true;  
               undo.discardAllEdits();//撤消所有的"撤消"操作  
               editMenu_Undo.setEnabled(false);  
               oldValue=editArea.getText();  
           }  
       }//新建结束  
       //打开  
       else if(e.getSource()==fileMenu_Open)  
       {   editArea.requestFocus();  
           String currentValue=editArea.getText();  
           boolean isTextChange=(currentValue.equals(oldValue))?false:true;  
           if(isTextChange)  
           {   int saveChoose=JOptionPane.showConfirmDialog(this,"您的文件尚未保存，是否保存？","提示",JOptionPane.YES_NO_CANCEL_OPTION);  
               if(saveChoose==JOptionPane.YES_OPTION)  
               {   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //fileChooser.setApproveButtonText("确定");  
                   fileChooser.setDialogTitle("另存为");  
                   int result=fileChooser.showSaveDialog(this);  
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("您没有选择任何文件");  
                       return;  
                   }  
                   File saveFileName=fileChooser.getSelectedFile();  
                   if(saveFileName==null || saveFileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else   
                   {   try  
                       {   FileWriter fw=new FileWriter(saveFileName);  
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           bfw.flush();//刷新该流的缓冲  
                           bfw.close();  
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                           this.setTitle(saveFileName.getName()+" - 记事本");  
                           statusLabel.setText("当前打开文件："+saveFileName.getAbsoluteFile());  
                       }  
                       catch (IOException ioException)  
                       {  
                       }  
                   }  
               }  
               else if(saveChoose==JOptionPane.NO_OPTION)  
               {   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //fileChooser.setApproveButtonText("确定");  
                   fileChooser.setDialogTitle("打开文件");  
                   int result=fileChooser.showOpenDialog(this);  
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("您没有选择任何文件");  
                       return;  
                   }  
                   File fileName=fileChooser.getSelectedFile();  
                   if(fileName==null || fileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else  
                   {   try  
                       {   FileReader fr=new FileReader(fileName);  
                           BufferedReader bfr=new BufferedReader(fr);  
                           editArea.setText("");  
                           while((str=bfr.readLine())!=null)  
                           {   editArea.append(str);  
                           }  
                           this.setTitle(fileName.getName()+" - 记事本");  
                           statusLabel.setText(" 当前打开文件："+fileName.getAbsoluteFile());  
                           fr.close();  
                           isNewFile=false;  
                           currentFile=fileName;  
                           oldValue=editArea.getText();  
                       }  
                       catch (IOException ioException)  
                       {  
                       }  
                   }  
               }  
               else  
               {   return;  
               }  
           }  
           else  
           {   String str=null;  
               JFileChooser fileChooser=new JFileChooser();  
               fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
               //fileChooser.setApproveButtonText("确定");  
               fileChooser.setDialogTitle("打开文件");  
               int result=fileChooser.showOpenDialog(this);  
               if(result==JFileChooser.CANCEL_OPTION)  
               {   statusLabel.setText(" 您没有选择任何文件 ");  
                   return;  
               }  
               File fileName=fileChooser.getSelectedFile();  
               if(fileName==null || fileName.getName().equals(""))  
               {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
               }  
               else  
               {   try  
                   {   FileReader fr=new FileReader(fileName);  
                       BufferedReader bfr=new BufferedReader(fr);  
                       editArea.setText("");  
                       while((str=bfr.readLine())!=null)  
                       {   editArea.append(str);  
                       }  
                       this.setTitle(fileName.getName()+" - 记事本");  
                       statusLabel.setText(" 当前打开文件："+fileName.getAbsoluteFile());  
                       fr.close();  
                       isNewFile=false;  
                       currentFile=fileName;  
                       oldValue=editArea.getText();  
                   }  
                   catch (IOException ioException)  
                   {  
                   }  
               }  
           }  
       }//打开结束  
       //保存  
       else if(e.getSource()==fileMenu_Save)  
       {   editArea.requestFocus();  
           if(isNewFile)  
           {   String str=null;  
               JFileChooser fileChooser=new JFileChooser();  
               fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
               //fileChooser.setApproveButtonText("确定");  
               fileChooser.setDialogTitle("保存");  
               int result=fileChooser.showSaveDialog(this);  
               if(result==JFileChooser.CANCEL_OPTION)  
               {   statusLabel.setText("您没有选择任何文件");  
                   return;  
               }  
               File saveFileName=fileChooser.getSelectedFile();  
               if(saveFileName==null || saveFileName.getName().equals(""))  
               {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
               }  
               else   
               {   try  
                   {   FileWriter fw=new FileWriter(saveFileName);  
                       BufferedWriter bfw=new BufferedWriter(fw);  
                       bfw.write(editArea.getText(),0,editArea.getText().length());  
                       bfw.flush();//刷新该流的缓冲  
                       bfw.close();  
                       isNewFile=false;  
                       currentFile=saveFileName;  
                       oldValue=editArea.getText();  
                       this.setTitle(saveFileName.getName()+" - 记事本");  
                       statusLabel.setText("当前打开文件："+saveFileName.getAbsoluteFile());  
                   }  
                   catch (IOException ioException)  
                   {  
                   }  
               }  
           }  
           else  
           {   try  
               {   FileWriter fw=new FileWriter(currentFile);  
                   BufferedWriter bfw=new BufferedWriter(fw);  
                   bfw.write(editArea.getText(),0,editArea.getText().length());  
                   bfw.flush();  
                   fw.close();  
               }                             
               catch(IOException ioException)  
               {                     
               }  
           }  
       }//保存结束  
       //另存为  
       else if(e.getSource()==fileMenu_SaveAs)  
       {   editArea.requestFocus();  
           String str=null;  
           JFileChooser fileChooser=new JFileChooser();  
           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
           //fileChooser.setApproveButtonText("确定");  
           fileChooser.setDialogTitle("另存为");  
           int result=fileChooser.showSaveDialog(this);  
           if(result==JFileChooser.CANCEL_OPTION)  
           {   statusLabel.setText("　您没有选择任何文件");  
               return;  
           }                 
           File saveFileName=fileChooser.getSelectedFile();  
           if(saveFileName==null||saveFileName.getName().equals(""))  
           {   JOptionPane.showMessageDialog(this,"不合法的文件名","不合法的文件名",JOptionPane.ERROR_MESSAGE);  
           }     
           else   
           {   try  
               {   FileWriter fw=new FileWriter(saveFileName);  
                   BufferedWriter bfw=new BufferedWriter(fw);  
                   bfw.write(editArea.getText(),0,editArea.getText().length());  
                   bfw.flush();  
                   fw.close();  
                   oldValue=editArea.getText();  
                   this.setTitle(saveFileName.getName()+"  - 记事本");  
                   statusLabel.setText("　当前打开文件:"+saveFileName.getAbsoluteFile());  
               }                         
               catch(IOException ioException)  
               {                     
               }                 
           }  
       }//另存为结束  
       //退出  
       else if(e.getSource()==fileMenu_Exit)  
       {   int exitChoose=JOptionPane.showConfirmDialog(this,"确定要退出吗?","退出提示",JOptionPane.OK_CANCEL_OPTION);  
           if(exitChoose==JOptionPane.OK_OPTION)  
           {   System.exit(0);  
           }  
           else  
           {   return;  
           }  
       }//退出结束  
       //编辑  
       //else if(e.getSource()==editMenu)  
       //{ checkMenuItemEnabled();//设置剪切、复制、粘贴、删除等功能的可用性  
       //}  
       //编辑结束  
       //撤销  
       else if(e.getSource()==editMenu_Undo || e.getSource()==popupMenu_Undo)  
       {   editArea.requestFocus();  
           if(undo.canUndo())  
           {   try  
               {   undo.undo();  
               }  
               catch (CannotUndoException ex)  
               {   System.out.println("Unable to undo:" + ex);  
                   //ex.printStackTrace();  
               }  
           }  
           if(!undo.canUndo())  
               {   editMenu_Undo.setEnabled(false);  
               }  
       }//撤销结束  
       //剪切  
       else if(e.getSource()==editMenu_Cut || e.getSource()==popupMenu_Cut)  
       {   editArea.requestFocus();  
           String text=editArea.getSelectedText();  
           StringSelection selection=new StringSelection(text);  
           clipBoard.setContents(selection,null);  
           editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();//设置剪切，复制，粘帖，删除功能的可用性  
       }//剪切结束  
       //复制  
       else if(e.getSource()==editMenu_Copy || e.getSource()==popupMenu_Copy)  
       {   editArea.requestFocus();  
           String text=editArea.getSelectedText();  
           StringSelection selection=new StringSelection(text);  
           clipBoard.setContents(selection,null);  
           checkMenuItemEnabled();//设置剪切，复制，粘帖，删除功能的可用性  
       }//复制结束  
       //粘帖  
       else if(e.getSource()==editMenu_Paste || e.getSource()==popupMenu_Paste)  
       {   editArea.requestFocus();  
           Transferable contents=clipBoard.getContents(this);  
           if(contents==null)return;  
           String text="";  
           try  
           {   text=(String)contents.getTransferData(DataFlavor.stringFlavor);  
           }  
           catch (Exception exception)  
           {  
           }  
           editArea.replaceRange(text,editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();  
       }//粘帖结束  
       //删除  
       else if(e.getSource()==editMenu_Delete || e.getSource()==popupMenu_Delete)  
       {   editArea.requestFocus();  
           editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled(); //设置剪切、复制、粘贴、删除等功能的可用性    
       }//删除结束  
       //查找 和替换
       else if(e.getSource()==editMenu_search)
		{    
			//查找对话框
			JDialog search=new JDialog(this,"查找和替换");
			search.setSize(400, 100);
			search.setLocation(450,350);
			JLabel label_1=new JLabel("查找的内容");
			JLabel label_2=new JLabel("替换的内容");
			final JTextField textField_1=new JTextField(5);
			final JTextField textField_2=new JTextField(5);
			JButton buttonFind=new JButton("查找下一个");
			JButton buttonChange=new JButton("替换");
			JPanel panel=new JPanel(new GridLayout(2,3));
			panel.add(label_1);
			panel.add(textField_1);
			panel.add(buttonFind);
			panel.add(label_2);
			panel.add(textField_2);
		    panel.add(buttonChange);
			search.add(panel);
			 search.setVisible(true);
			
			
			//为查找下一个 按钮绑定监听事件
			buttonFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				   String findText=textField_1.getText();//查找的字符串
				   
				   String textArea=myarea.getText();//当前文本框的内容
				   start=textArea.indexOf(findText,end);
				   end=start+findText.length();
				   if(start==-1)//没有找到
				   {
					   JOptionPane.showMessageDialog(null,"没找到"+findText,"记事本",JOptionPane.WARNING_MESSAGE);
					   myarea.select(start, end);
				   }
				   else
				   {
					   myarea.select(start,end);
				   }
				   
				}
			});
			//为替换按钮绑定监听时间
		    buttonChange.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String changeText=textField_2.getText();//替换的字符串
					myarea.select(start, end);
					myarea.replaceSelection(changeText);
					myarea.select(start, end);					
				}
			});  
			  
		    
			
			
		}

       //时间日期  
       else if(e.getSource()==editMenu_TimeDate)  
       {   editArea.requestFocus();  
           //SimpleDateFormat currentDateTime=new SimpleDateFormat("HH:mmyyyy-MM-dd");  
           //editArea.insert(currentDateTime.format(new Date()),editArea.getCaretPosition());  
           Calendar rightNow=Calendar.getInstance();  
           Date date=rightNow.getTime();  
           editArea.insert(date.toString(),editArea.getCaretPosition());  
       }//时间日期结束  
       //全选  
       else if(e.getSource()==editMenu_SelectAll || e.getSource()==popupMenu_SelectAll)  
       {   editArea.selectAll();  
       }//全选结束  
   }//方法actionPerformed()结束  
 
   //实现DocumentListener接口中的方法(与撤销操作有关)  
   public void removeUpdate(DocumentEvent e)  
   {   editMenu_Undo.setEnabled(true);  
   }  
   public void insertUpdate(DocumentEvent e)  
   {   editMenu_Undo.setEnabled(true);  
   }  
   public void changedUpdate(DocumentEvent e)  
   {   editMenu_Undo.setEnabled(true);  
   }//DocumentListener结束  
 
   //实现接口UndoableEditListener的类UndoHandler(与撤销操作有关)  
   class UndoHandler implements UndoableEditListener  
   {   public void undoableEditHappened(UndoableEditEvent uee)  
       {   undo.addEdit(uee.getEdit());  
       }  
   }  
 
   //main函数开始  
   public static void main(String args[])  
   {   Notepad notepad=new Notepad();  
       notepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使用 System exit 方法退出应用程序  
   }}//main函数结束  




