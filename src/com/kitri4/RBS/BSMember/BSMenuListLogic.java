package com.kitri4.RBS.BSMember;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;


public class BSMenuListLogic implements ActionListener{
   BSMenuList bsmenulist;
   
   public BSMenuListLogic(BSMenuList bsmenulist ){
      this.bsmenulist=bsmenulist;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      Object ob = e.getSource();
      if(ob==bsmenulist.menuAddBtn){
         //신규 메뉴 등록 버튼
        
         bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_3);
         
      }else if(ob ==bsmenulist.openPicturBtn){
         //사진 불러오기 
         //열기
         
         FileNameExtensionFilter filter=new FileNameExtensionFilter("Images(BMP,JPEG,PNG, extensions)","bmp","jpg","png");
         bsmenulist.fc.setDialogTitle("image 를 선택하세요");
         bsmenulist.fc.setFileFilter(filter);
         bsmenulist.fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
         if(bsmenulist.fc.showOpenDialog(bsmenulist.fileOpen) ==JFileChooser.APPROVE_OPTION){
            bsmenulist.Seepicture.setText("");
            File saveFile = bsmenulist.fc.getSelectedFile(); // 파일 저장됨 지금 아무것도 안하고있음.
            String filename = bsmenulist.fc.getSelectedFile().getAbsolutePath(); //경로 저장
            ImageIcon imageicon = new ImageIcon(filename); //경로로 이미지아이콘생성
            Image image = imageicon.getImage().getScaledInstance(200,120, Image.SCALE_SMOOTH); //사이즈지정
            bsmenulist.Seepicture.setIcon(new ImageIcon(image));//Seepicture 라벨에 이미지 뿌리기
         }else{
            //취소 버튼을 누르면
            bsmenulist.Seepicture.setIcon(new ImageIcon());
            bsmenulist.Seepicture.setText("파일을 열지 못했습니다"); 
         }                        
      }else if(ob ==bsmenulist.addMenuBtn){//등록
         
         String menuName = bsmenulist.menuNameTf.getText();
         String menuPrice = bsmenulist.priceTf.getText();
         String menuInformation = bsmenulist.menuInfoTf.getText();
         bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);
         
      }else if(ob ==bsmenulist.renameMenuBtn){//수정
         
         String menuName = bsmenulist.menuNameTf.getText();
         String menuPrice = bsmenulist.priceTf.getText();
         String menuInformation = bsmenulist.menuInfoTf.getText();
         bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);
         
      }else if(ob ==bsmenulist.removeMenuBtn){//삭제버튼
         
         bsmenulist.dialog.setTitle("삭제 하시겠습니까?");
         bsmenulist.dialog.setSize(200, 80);
         bsmenulist.dialog.setLocation(900, 500);
         bsmenulist.dialog.setVisible(true);         
      }
      else if(e.getSource() == bsmenulist.okBtn){
         bsmenulist.dialog.dispose();   
         //삭제 Source 필요
         bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);
      }         
      else if(e.getSource() == bsmenulist.cencelBtn){            
         bsmenulist.dialog.dispose();         
      }
      else if(e.getSource() == bsmenulist.storeMenuBtn){
         bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_2);
      }
    }   
}










class ButtonRenderer extends JButton implements TableCellRenderer{
   
    JButton button = new JButton("");
    public String label;
    public boolean isPushed;
    public ButtonRenderer() {
       setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable ingAuctionTable, Object value, boolean isSelected, boolean hasFocus,
          int row, int column) {    
            setText((value == null) ? "수정" : value.toString());
          return this;
    }
}

class ButtonEditor extends DefaultCellEditor{

   BSMenuList bsmenulist;
   int row=0;
    protected JButton button;
    private String label;
    private boolean isPushed;
    public ButtonEditor(JComboBox comboBox,BSMenuList bsmenulist) {
       super(comboBox);
       this.bsmenulist=bsmenulist;
       button =new JButton();
       button.setOpaque(true);
       button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             fireEditingStopped();              
             System.out.println(row+"번째테이블");
             bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_3);
          }
       });   
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value
                , boolean isSelected, int row, int column) {   
       this.row=row;
       return button;
    }
 
}














/*
//BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements TableCellRenderer{
     
      
   
   //생성자 CONSTURCTOR
   public ButtonRenderer(){
      //SET Button Properties
      setOpaque(true);
   }

   @Override
   public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused,
         int row, int col) {
  
      
         //SET Passed object as button text
         setText((obj ==null) ? "zz" :obj.toString());
      
      return this;
   }
}


//BUTTON EDITOR CLASS
class ButtonEditor extends DefaultCellEditor{
   BSMenuList bsmenulist;
      
   protected JButton btn;
   private String lbl;
   private Boolean clicked;
   int row;
   
   
   public ButtonEditor(JTextField txt) {
      super(txt);
      
      btn = new JButton();
      btn.setOpaque(true);
      
      //WHEN BUTTON IS CLICKED
      btn.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
           
         bsmenulist.tabbedPane.setSelectedComponent(bsmenulist.panel_3);
            fireEditingStopped();
          
         }
      });
   }
     //OVERRIDE A COUPLE OF METHODS
   @Override
   public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
      this.row=row;
            
      
      //SET TEXT TO BUTTON, SET CLICKED TO TRUE , THEN RETRUN THE BTN OBJECT
      lbl=(obj==null)? "":obj.toString();
      btn.setText(lbl);
      clicked=true;      
      return btn;
   }
   //IF button cell value changes, if clicked that is
   @Override
   public Object getCellEditorValue() {
      if(clicked){
         //Show us some message         
         System.out.println("row  : "+row);         
         //JOptionPane.showMessageDialog(btn, "이벤트 등록해야함");
      }
      //Set it to false now that its clicked
      clicked =false;
      
      return new String(lbl);
   }
   
   @Override
   public boolean stopCellEditing() {
      //Set Clicked to false first
      clicked=false;
      
      return super.stopCellEditing();
   }
   
   @Override
   protected void fireEditingCanceled() {   
      super.fireEditingCanceled();
   }
}*/