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
{   //�˵�
   JMenu fileMenu,editMenu,formatMenu;//JMenu����һ���˵�   
   //�Ҽ������˵���
   JPopupMenu popupMenu;//JPopupMenu����ʽ�˵�  
   JMenuItem popupMenu_Undo,popupMenu_Cut,popupMenu_Copy,popupMenu_Paste,popupMenu_Delete,popupMenu_SelectAll;  //���ļ����Ĳ˵���  
   //JMenuItem����˵���
   //���ļ����Ĳ˵���  
   JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_Exit;
   //���༭���Ĳ˵���  
   JMenuItem editMenu_Undo,editMenu_Cut,editMenu_Copy,editMenu_Paste,editMenu_Delete,editMenu_search,editMenu_SelectAll,editMenu_TimeDate;  
   //���ı����༭����  
   JTextArea editArea;  
   //״̬����ǩ  
   JLabel statusLabel;//JLabel��ʾ�ı���ͼ��  
   
   JTextArea myarea=new JTextArea();
   int start=0;//���ҿ�ʼλ��
   int end=0;//���ҽ���λ��

   
   //ϵͳ������  
   Toolkit toolkit=Toolkit.getDefaultToolkit();//���߰�  
   Clipboard clipBoard=toolkit.getSystemClipboard();//��ȡ���滻�������ı�����  
   //������������������(�볷�������й�)  
   protected UndoManager undo=new UndoManager();  
   protected UndoableEditListener undoHandler=new UndoHandler();  
   //��������  
   String oldValue;//��ű༭��ԭ�������ݣ����ڱȽ��ı��Ƿ��иĶ�  
   boolean isNewFile=true;//�Ƿ����ļ�(δ�������)  
   File currentFile;//��ǰ�ļ���  
   //���캯����ʼ  
   public Notepad()  
   {     
       super("Java���±�");  
       //�ı�ϵͳĬ������  
       Font font = new Font("Dialog", Font.PLAIN, 12);  
       java.util.Enumeration keys = UIManager.getDefaults().keys();  
       while (keys.hasMoreElements()) {  
           Object key = keys.nextElement();  
           Object value = UIManager.get(key);  
           if (value instanceof javax.swing.plaf.FontUIResource) {  
               UIManager.put(key, font);  
           }  
       }  
       //�����˵���  
       JMenuBar menuBar=new JMenuBar();  
       //�����ļ��˵����˵��ע���¼�����  
       fileMenu=new JMenu("�ļ�(F)");  
       fileMenu.setMnemonic('F');//���ÿ�ݼ�ALT+F  
 
       fileMenu_New=new JMenuItem("�½�(N)");  
       fileMenu_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));  
       fileMenu_New.addActionListener(this);  
 
       fileMenu_Open=new JMenuItem("��(O)...");  
       fileMenu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));  
       fileMenu_Open.addActionListener(this);  
 
       fileMenu_Save=new JMenuItem("����(S)");  
       fileMenu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));  
       fileMenu_Save.addActionListener(this);  
 
       fileMenu_SaveAs=new JMenuItem("���Ϊ(A)...");  
       fileMenu_SaveAs.addActionListener(this);  
 
 
       fileMenu_Exit=new JMenuItem("�˳�(X)");  
       fileMenu_Exit.addActionListener(this);  
 
       //�����༭�˵����˵��ע���¼�����  
       editMenu=new JMenu("�༭(E)");  
       editMenu.setMnemonic('E');//���ÿ�ݼ�ALT+E  
       //��ѡ��༭�˵�ʱ�����ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����  
       editMenu.addMenuListener(new MenuListener()  
       {   public void menuCanceled(MenuEvent e)//ȡ���˵�ʱ����  
           {   checkMenuItemEnabled();//���ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����  
           }  
           public void menuDeselected(MenuEvent e)//ȡ��ѡ��ĳ���˵�ʱ����  
           {   checkMenuItemEnabled();//���ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����  
           }  
           public void menuSelected(MenuEvent e)//ѡ��ĳ���˵�ʱ����  
           {   checkMenuItemEnabled();//���ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����  
           }  
       });  
 
       editMenu_Undo=new JMenuItem("����(U)");  
       editMenu_Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));  
       editMenu_Undo.addActionListener(this);  
       editMenu_Undo.setEnabled(false);  
 
       editMenu_Cut=new JMenuItem("����(T)");  
       editMenu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));  
       editMenu_Cut.addActionListener(this);  
 
       editMenu_Copy=new JMenuItem("����(C)");  
       editMenu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));  
       editMenu_Copy.addActionListener(this);  
 
       editMenu_Paste=new JMenuItem("ճ��(P)");  
       editMenu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));  
       editMenu_Paste.addActionListener(this);  
 
       editMenu_Delete=new JMenuItem("ɾ��(D)");  
       editMenu_Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));  
       editMenu_Delete.addActionListener(this);  
 
       editMenu_search=new JMenuItem("���Һ��滻(F)...");  
       editMenu_search.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));  
       editMenu_search.addActionListener(this);  
 
 
       editMenu_SelectAll = new JMenuItem("ȫѡ",'A');   
       editMenu_SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));   
       editMenu_SelectAll.addActionListener(this);  
 
       editMenu_TimeDate = new JMenuItem("ʱ��/����(D)",'D');  
       editMenu_TimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));  
       editMenu_TimeDate.addActionListener(this);  
 
 
       //��˵������"�ļ�"�˵����˵���  
       menuBar.add(fileMenu);   
       fileMenu.add(fileMenu_New);   
       fileMenu.add(fileMenu_Open);   
       fileMenu.add(fileMenu_Save);   
       fileMenu.add(fileMenu_SaveAs);   
       fileMenu.addSeparator();        //�ָ���   
       fileMenu.add(fileMenu_Exit);   
 
       //��˵������"�༭"�˵����˵���   
       menuBar.add(editMenu);   
       editMenu.add(editMenu_Undo);    
       editMenu.addSeparator();        //�ָ���   
       editMenu.add(editMenu_Cut);   
       editMenu.add(editMenu_Copy);   
       editMenu.add(editMenu_Paste);   
       editMenu.add(editMenu_Delete);   
       editMenu.addSeparator();        //�ָ���  
       editMenu.add(editMenu_search);      
       editMenu.addSeparator();        //�ָ���  
       editMenu.add(editMenu_SelectAll);   
       editMenu.add(editMenu_TimeDate);  
 
                 
       //�򴰿���Ӳ˵���                
       this.setJMenuBar(menuBar);  
 
       //�����ı��༭������ӹ�����  
       editArea=new JTextArea(20,50);  
       JScrollPane scroller=new JScrollPane(editArea);  
       scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //��ֱ�Ĺ�����
       this.add(scroller,BorderLayout.CENTER);//�򴰿�����ı��༭��  
       editArea.setWrapStyleWord(true);//���õ�����һ�в�������ʱ����  
       editArea.setLineWrap(true);//�����ı��༭���Զ�����Ĭ��Ϊtrue,����"�Զ�����"  
       //this.add(editArea,BorderLayout.CENTER);//�򴰿�����ı��༭��  
       oldValue=editArea.getText();//��ȡԭ�ı��༭��������  
 
       //�༭��ע���¼�����(�볷�������й�)  
       editArea.getDocument().addUndoableEditListener(undoHandler);  
       editArea.getDocument().addDocumentListener(this);  
 
       //�����Ҽ������˵�  
       popupMenu=new JPopupMenu();  
       popupMenu_Undo=new JMenuItem("����(U)");  
       popupMenu_Cut=new JMenuItem("����(T)");  
       popupMenu_Copy=new JMenuItem("����(C)");  
       popupMenu_Paste=new JMenuItem("ճ��(P)");  
       popupMenu_Delete=new JMenuItem("ɾ��(D)");  
       popupMenu_SelectAll=new JMenuItem("ȫѡ(A)");  
 
       popupMenu_Undo.setEnabled(false);  
 
       //���Ҽ��˵���Ӳ˵���ͷָ���  
       popupMenu.add(popupMenu_Undo);  
       popupMenu.addSeparator();  
       popupMenu.add(popupMenu_Cut);  
       popupMenu.add(popupMenu_Copy);  
       popupMenu.add(popupMenu_Paste);  
       popupMenu.add(popupMenu_Delete);  
       popupMenu.addSeparator(); //�ָ���
       popupMenu.add(popupMenu_SelectAll);  
 
       //�ı��༭��ע���Ҽ��˵��¼�  
       popupMenu_Undo.addActionListener(this);  
       popupMenu_Cut.addActionListener(this);  
       popupMenu_Copy.addActionListener(this);  
       popupMenu_Paste.addActionListener(this);  
       popupMenu_Delete.addActionListener(this);  
       popupMenu_SelectAll.addActionListener(this);  
 
       //�ı��༭��ע���Ҽ��˵��¼�  
       editArea.addMouseListener(new MouseAdapter()  
       {   public void mousePressed(MouseEvent e)  
           {   if(e.isPopupTrigger())//���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�  
               {   popupMenu.show(e.getComponent(),e.getX(),e.getY());//����������ߵ�����ռ��е�λ�� X��Y ��ʾ�����˵�  
               }  
               checkMenuItemEnabled();//���ü��У����ƣ�ճ����ɾ���ȹ��ܵĿ�����  
               editArea.requestFocus();//�༭����ȡ����  
           }  
           public void mouseReleased(MouseEvent e)  
           {   if(e.isPopupTrigger())//���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�  
               {   popupMenu.show(e.getComponent(),e.getX(),e.getY());//����������ߵ�����ռ��е�λ�� X��Y ��ʾ�����˵�  
               }  
               checkMenuItemEnabled();//���ü��У����ƣ�ճ����ɾ���ȹ��ܵĿ�����  
               editArea.requestFocus();//�༭����ȡ����  
           }  
       });//�ı��༭��ע���Ҽ��˵��¼�����  
 
 
       //���ô�������Ļ�ϵ�λ�á���С�Ϳɼ���   
       this.setLocation(100,100);  
       this.setSize(650,550);  
       this.setVisible(true);  //�ɼ���
       //��Ӵ��ڼ�����  
       addWindowListener(new WindowAdapter()  
       {   public void windowClosing(WindowEvent e)  
           {   exitWindowChoose();  
           }  
       });  
 
       checkMenuItemEnabled();  
       editArea.requestFocus();  
   }//���캯��Notepad����  
     
   //���ò˵���Ŀ����ԣ����У����ƣ�ճ����ɾ������  
   public void checkMenuItemEnabled()  
   {   String selectText=editArea.getSelectedText();  
       if(selectText==null)  //�ı�Ϊ��
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
       //ճ�����ܿ������ж�  
       Transferable contents=clipBoard.getContents(this);  //����
       if(contents==null)  
       {   editMenu_Paste.setEnabled(false);  
           popupMenu_Paste.setEnabled(false);  
       }  
       else  
       {   editMenu_Paste.setEnabled(true);  
           popupMenu_Paste.setEnabled(true);     
       }  
   }//����checkMenuItemEnabled()����  
 
   //�رմ���ʱ����  
   public void exitWindowChoose()  
   {   editArea.requestFocus();  
       String currentValue=editArea.getText();  
       if(currentValue.equals(oldValue)==true)  
       {   System.exit(0);  
       }  
       else  
       {   int exitChoose=JOptionPane.showConfirmDialog(this,"�����ļ���δ���棬�Ƿ񱣴棿","�˳���ʾ",JOptionPane.YES_NO_CANCEL_OPTION);  
           if(exitChoose==JOptionPane.YES_OPTION)  
           {   //boolean isSave=false;  
               if(isNewFile)  //�ж��Ƿ�Ϊ���ļ�
               {     
                   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   fileChooser.setApproveButtonText("ȷ��");  
                   fileChooser.setDialogTitle("���Ϊ");  
                     
                   int result=fileChooser.showSaveDialog(this);  
                     
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("����û�б����ļ�");  
                       return;  
                   }                     
     
                   File saveFileName=fileChooser.getSelectedFile();  
                 
                   if(saveFileName==null||saveFileName.getName().equals(""))  //�ļ���
                   {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
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
                             
                           this.setTitle(saveFileName.getName()+"  - ���±�");  
                           statusLabel.setText("����ǰ���ļ�:"+saveFileName.getAbsoluteFile());  
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
   //�رմ���ʱ���÷�������  
 
 
   //public void menuPerformed(MenuEvent e)  
   //{ checkMenuItemEnabled();//���ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����  
   //}  
 
   public void actionPerformed(ActionEvent e)  
   {   //�½�  
       if(e.getSource()==fileMenu_New)  
       {   editArea.requestFocus();  
           String currentValue=editArea.getText();  
           boolean isTextChange=(currentValue.equals(oldValue))?false:true;  
           if(isTextChange)  
           {   int saveChoose=JOptionPane.showConfirmDialog(this,"�����ļ���δ���棬�Ƿ񱣴棿","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);  
               if(saveChoose==JOptionPane.YES_OPTION)  
               {   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //fileChooser.setApproveButtonText("ȷ��");  
                   fileChooser.setDialogTitle("���Ϊ");  
                   int result=fileChooser.showSaveDialog(this);  
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("��û��ѡ���κ��ļ�");  
                       return;  
                   }  
                   File saveFileName=fileChooser.getSelectedFile();  
                   if(saveFileName==null || saveFileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else   
                   {   try  
                       {   FileWriter fw=new FileWriter(saveFileName);  
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           bfw.flush();//ˢ�¸����Ļ���  
                           bfw.close();  
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                           this.setTitle(saveFileName.getName()+" - ���±�");  
                           statusLabel.setText("��ǰ���ļ���"+saveFileName.getAbsoluteFile());  
                       }  
                       catch (IOException ioException)  
                       {  
                       }  
                   }  
               }  
               else if(saveChoose==JOptionPane.NO_OPTION)  
               {   editArea.replaceRange("",0,editArea.getText().length());  
                   statusLabel.setText(" �½��ļ�");  
                   this.setTitle("�ޱ��� - ���±�");  
                   isNewFile=true;  
                   undo.discardAllEdits(); //�������е�"����"����  
                   editMenu_Undo.setEnabled(false);  
                   oldValue=editArea.getText();  
               }  
               else if(saveChoose==JOptionPane.CANCEL_OPTION)  
               {   return;  
               }  
           }  
           else  
           {   editArea.replaceRange("",0,editArea.getText().length());  
               statusLabel.setText(" �½��ļ�");  
               this.setTitle("�ޱ��� - ���±�");  
               isNewFile=true;  
               undo.discardAllEdits();//�������е�"����"����  
               editMenu_Undo.setEnabled(false);  
               oldValue=editArea.getText();  
           }  
       }//�½�����  
       //��  
       else if(e.getSource()==fileMenu_Open)  
       {   editArea.requestFocus();  
           String currentValue=editArea.getText();  
           boolean isTextChange=(currentValue.equals(oldValue))?false:true;  
           if(isTextChange)  
           {   int saveChoose=JOptionPane.showConfirmDialog(this,"�����ļ���δ���棬�Ƿ񱣴棿","��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);  
               if(saveChoose==JOptionPane.YES_OPTION)  
               {   String str=null;  
                   JFileChooser fileChooser=new JFileChooser();  
                   fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
                   //fileChooser.setApproveButtonText("ȷ��");  
                   fileChooser.setDialogTitle("���Ϊ");  
                   int result=fileChooser.showSaveDialog(this);  
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("��û��ѡ���κ��ļ�");  
                       return;  
                   }  
                   File saveFileName=fileChooser.getSelectedFile();  
                   if(saveFileName==null || saveFileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else   
                   {   try  
                       {   FileWriter fw=new FileWriter(saveFileName);  
                           BufferedWriter bfw=new BufferedWriter(fw);  
                           bfw.write(editArea.getText(),0,editArea.getText().length());  
                           bfw.flush();//ˢ�¸����Ļ���  
                           bfw.close();  
                           isNewFile=false;  
                           currentFile=saveFileName;  
                           oldValue=editArea.getText();  
                           this.setTitle(saveFileName.getName()+" - ���±�");  
                           statusLabel.setText("��ǰ���ļ���"+saveFileName.getAbsoluteFile());  
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
                   //fileChooser.setApproveButtonText("ȷ��");  
                   fileChooser.setDialogTitle("���ļ�");  
                   int result=fileChooser.showOpenDialog(this);  
                   if(result==JFileChooser.CANCEL_OPTION)  
                   {   statusLabel.setText("��û��ѡ���κ��ļ�");  
                       return;  
                   }  
                   File fileName=fileChooser.getSelectedFile();  
                   if(fileName==null || fileName.getName().equals(""))  
                   {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
                   }  
                   else  
                   {   try  
                       {   FileReader fr=new FileReader(fileName);  
                           BufferedReader bfr=new BufferedReader(fr);  
                           editArea.setText("");  
                           while((str=bfr.readLine())!=null)  
                           {   editArea.append(str);  
                           }  
                           this.setTitle(fileName.getName()+" - ���±�");  
                           statusLabel.setText(" ��ǰ���ļ���"+fileName.getAbsoluteFile());  
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
               //fileChooser.setApproveButtonText("ȷ��");  
               fileChooser.setDialogTitle("���ļ�");  
               int result=fileChooser.showOpenDialog(this);  
               if(result==JFileChooser.CANCEL_OPTION)  
               {   statusLabel.setText(" ��û��ѡ���κ��ļ� ");  
                   return;  
               }  
               File fileName=fileChooser.getSelectedFile();  
               if(fileName==null || fileName.getName().equals(""))  
               {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
               }  
               else  
               {   try  
                   {   FileReader fr=new FileReader(fileName);  
                       BufferedReader bfr=new BufferedReader(fr);  
                       editArea.setText("");  
                       while((str=bfr.readLine())!=null)  
                       {   editArea.append(str);  
                       }  
                       this.setTitle(fileName.getName()+" - ���±�");  
                       statusLabel.setText(" ��ǰ���ļ���"+fileName.getAbsoluteFile());  
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
       }//�򿪽���  
       //����  
       else if(e.getSource()==fileMenu_Save)  
       {   editArea.requestFocus();  
           if(isNewFile)  
           {   String str=null;  
               JFileChooser fileChooser=new JFileChooser();  
               fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
               //fileChooser.setApproveButtonText("ȷ��");  
               fileChooser.setDialogTitle("����");  
               int result=fileChooser.showSaveDialog(this);  
               if(result==JFileChooser.CANCEL_OPTION)  
               {   statusLabel.setText("��û��ѡ���κ��ļ�");  
                   return;  
               }  
               File saveFileName=fileChooser.getSelectedFile();  
               if(saveFileName==null || saveFileName.getName().equals(""))  
               {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
               }  
               else   
               {   try  
                   {   FileWriter fw=new FileWriter(saveFileName);  
                       BufferedWriter bfw=new BufferedWriter(fw);  
                       bfw.write(editArea.getText(),0,editArea.getText().length());  
                       bfw.flush();//ˢ�¸����Ļ���  
                       bfw.close();  
                       isNewFile=false;  
                       currentFile=saveFileName;  
                       oldValue=editArea.getText();  
                       this.setTitle(saveFileName.getName()+" - ���±�");  
                       statusLabel.setText("��ǰ���ļ���"+saveFileName.getAbsoluteFile());  
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
       }//�������  
       //���Ϊ  
       else if(e.getSource()==fileMenu_SaveAs)  
       {   editArea.requestFocus();  
           String str=null;  
           JFileChooser fileChooser=new JFileChooser();  
           fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);  
           //fileChooser.setApproveButtonText("ȷ��");  
           fileChooser.setDialogTitle("���Ϊ");  
           int result=fileChooser.showSaveDialog(this);  
           if(result==JFileChooser.CANCEL_OPTION)  
           {   statusLabel.setText("����û��ѡ���κ��ļ�");  
               return;  
           }                 
           File saveFileName=fileChooser.getSelectedFile();  
           if(saveFileName==null||saveFileName.getName().equals(""))  
           {   JOptionPane.showMessageDialog(this,"���Ϸ����ļ���","���Ϸ����ļ���",JOptionPane.ERROR_MESSAGE);  
           }     
           else   
           {   try  
               {   FileWriter fw=new FileWriter(saveFileName);  
                   BufferedWriter bfw=new BufferedWriter(fw);  
                   bfw.write(editArea.getText(),0,editArea.getText().length());  
                   bfw.flush();  
                   fw.close();  
                   oldValue=editArea.getText();  
                   this.setTitle(saveFileName.getName()+"  - ���±�");  
                   statusLabel.setText("����ǰ���ļ�:"+saveFileName.getAbsoluteFile());  
               }                         
               catch(IOException ioException)  
               {                     
               }                 
           }  
       }//���Ϊ����  
       //�˳�  
       else if(e.getSource()==fileMenu_Exit)  
       {   int exitChoose=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳���?","�˳���ʾ",JOptionPane.OK_CANCEL_OPTION);  
           if(exitChoose==JOptionPane.OK_OPTION)  
           {   System.exit(0);  
           }  
           else  
           {   return;  
           }  
       }//�˳�����  
       //�༭  
       //else if(e.getSource()==editMenu)  
       //{ checkMenuItemEnabled();//���ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����  
       //}  
       //�༭����  
       //����  
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
       }//��������  
       //����  
       else if(e.getSource()==editMenu_Cut || e.getSource()==popupMenu_Cut)  
       {   editArea.requestFocus();  
           String text=editArea.getSelectedText();  
           StringSelection selection=new StringSelection(text);  
           clipBoard.setContents(selection,null);  
           editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled();//���ü��У����ƣ�ճ����ɾ�����ܵĿ�����  
       }//���н���  
       //����  
       else if(e.getSource()==editMenu_Copy || e.getSource()==popupMenu_Copy)  
       {   editArea.requestFocus();  
           String text=editArea.getSelectedText();  
           StringSelection selection=new StringSelection(text);  
           clipBoard.setContents(selection,null);  
           checkMenuItemEnabled();//���ü��У����ƣ�ճ����ɾ�����ܵĿ�����  
       }//���ƽ���  
       //ճ��  
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
       }//ճ������  
       //ɾ��  
       else if(e.getSource()==editMenu_Delete || e.getSource()==popupMenu_Delete)  
       {   editArea.requestFocus();  
           editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());  
           checkMenuItemEnabled(); //���ü��С����ơ�ճ����ɾ���ȹ��ܵĿ�����    
       }//ɾ������  
       //���� ���滻
       else if(e.getSource()==editMenu_search)
		{    
			//���ҶԻ���
			JDialog search=new JDialog(this,"���Һ��滻");
			search.setSize(400, 100);
			search.setLocation(450,350);
			JLabel label_1=new JLabel("���ҵ�����");
			JLabel label_2=new JLabel("�滻������");
			final JTextField textField_1=new JTextField(5);
			final JTextField textField_2=new JTextField(5);
			JButton buttonFind=new JButton("������һ��");
			JButton buttonChange=new JButton("�滻");
			JPanel panel=new JPanel(new GridLayout(2,3));
			panel.add(label_1);
			panel.add(textField_1);
			panel.add(buttonFind);
			panel.add(label_2);
			panel.add(textField_2);
		    panel.add(buttonChange);
			search.add(panel);
			 search.setVisible(true);
			
			
			//Ϊ������һ�� ��ť�󶨼����¼�
			buttonFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				   String findText=textField_1.getText();//���ҵ��ַ���
				   
				   String textArea=myarea.getText();//��ǰ�ı��������
				   start=textArea.indexOf(findText,end);
				   end=start+findText.length();
				   if(start==-1)//û���ҵ�
				   {
					   JOptionPane.showMessageDialog(null,"û�ҵ�"+findText,"���±�",JOptionPane.WARNING_MESSAGE);
					   myarea.select(start, end);
				   }
				   else
				   {
					   myarea.select(start,end);
				   }
				   
				}
			});
			//Ϊ�滻��ť�󶨼���ʱ��
		    buttonChange.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String changeText=textField_2.getText();//�滻���ַ���
					myarea.select(start, end);
					myarea.replaceSelection(changeText);
					myarea.select(start, end);					
				}
			});  
			  
		    
			
			
		}

       //ʱ������  
       else if(e.getSource()==editMenu_TimeDate)  
       {   editArea.requestFocus();  
           //SimpleDateFormat currentDateTime=new SimpleDateFormat("HH:mmyyyy-MM-dd");  
           //editArea.insert(currentDateTime.format(new Date()),editArea.getCaretPosition());  
           Calendar rightNow=Calendar.getInstance();  
           Date date=rightNow.getTime();  
           editArea.insert(date.toString(),editArea.getCaretPosition());  
       }//ʱ�����ڽ���  
       //ȫѡ  
       else if(e.getSource()==editMenu_SelectAll || e.getSource()==popupMenu_SelectAll)  
       {   editArea.selectAll();  
       }//ȫѡ����  
   }//����actionPerformed()����  
 
   //ʵ��DocumentListener�ӿ��еķ���(�볷�������й�)  
   public void removeUpdate(DocumentEvent e)  
   {   editMenu_Undo.setEnabled(true);  
   }  
   public void insertUpdate(DocumentEvent e)  
   {   editMenu_Undo.setEnabled(true);  
   }  
   public void changedUpdate(DocumentEvent e)  
   {   editMenu_Undo.setEnabled(true);  
   }//DocumentListener����  
 
   //ʵ�ֽӿ�UndoableEditListener����UndoHandler(�볷�������й�)  
   class UndoHandler implements UndoableEditListener  
   {   public void undoableEditHappened(UndoableEditEvent uee)  
       {   undo.addEdit(uee.getEdit());  
       }  
   }  
 
   //main������ʼ  
   public static void main(String args[])  
   {   Notepad notepad=new Notepad();  
       notepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ʹ�� System exit �����˳�Ӧ�ó���  
   }}//main��������  




