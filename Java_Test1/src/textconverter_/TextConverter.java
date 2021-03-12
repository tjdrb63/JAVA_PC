package textconverter_;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.google.gson.JsonArray;
import com.google.gson.*;
import com.google.gson.JsonParser;
import org.json.simple.parser.ParseException;

/*
 * 	���İ� API ����
 * 
 * 
 * */

public class TextConverter extends JFrame implements ActionListener{

   private JButton converBtn;
   private JButton cancelBtn;
   private JTextArea textIn;
   private JTextArea textOut;
   
   
   public TextConverter() {
      super("�ؽ�Ʈ ��ȯ");
      textIn = new JTextArea(10,14);
      textOut = new JTextArea(10,14);
      textIn.setLineWrap(true);
      textOut.setLineWrap(true);

      textIn.setEditable(true);
      textOut.setEditable(false);
      
      JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
      
      textAreaPanel.add(textIn);
      textAreaPanel.add(textOut);
      
      converBtn = new JButton("��ȯ");
      converBtn.addActionListener(this);
      cancelBtn = new JButton("���");
      cancelBtn.addActionListener(this);
      
      JPanel btnPanel = new JPanel();
      btnPanel.add(converBtn);
      btnPanel.add(cancelBtn);
      
      JPanel mainPanel = new JPanel(new BorderLayout(10,10));
      mainPanel.add(textAreaPanel,BorderLayout.CENTER);
      mainPanel.add(btnPanel,BorderLayout.SOUTH);
      
      this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
      this.add(mainPanel);
      this.pack();
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()== converBtn) {
         textOut.setText("");
         String result = PapagoTrans(textIn.getText());
         textOut.setText(result);
      }
      else if(e.getSource()==cancelBtn)
      {
         textOut.setText(null);
         textIn.setText(null);     
      }
   }
   
   public static void main(String[] args)
   {
      new TextConverter();
   
   }
   
   public String PapagoTrans(String str) {
       String clientId = "ipg1GaIWLfKpfzSpIpRm";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
       String clientSecret = "hDKH5Y2zNR";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
       try {
           String text = URLEncoder.encode(str, "UTF-8");
           String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
           URL url = new URL(apiURL);
           HttpURLConnection con = (HttpURLConnection)url.openConnection();
           con.setRequestMethod("POST");
           con.setRequestProperty("X-Naver-Client-Id", clientId);
           con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
           // post request
           String postParams = "source=ko&target=en&text=" + text;
           con.setDoOutput(true);
           DataOutputStream wr = new DataOutputStream(con.getOutputStream());
           wr.writeBytes(postParams);
           wr.flush();
           wr.close();
           int responseCode = con.getResponseCode();
           BufferedReader br;
           if(responseCode==200) { // ���� ȣ��
               br = new BufferedReader(new InputStreamReader(con.getInputStream()));
           } else {  // ���� �߻�
               br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
           }
           String inputLine;
           StringBuffer response = new StringBuffer();
           while ((inputLine = br.readLine()) != null) {
               response.append(inputLine);
           }
           br.close();
           String TransText = response.toString(); // JSon -> String
       
           JsonParser parser = new JsonParser();    
           JsonObject obj = (JsonObject) parser.parse(TransText); //JSon (massage -> result -> trans...)
           
           JsonObject msg = (JsonObject) obj.get("message"); //obj -> msg
           JsonObject Result = (JsonObject) msg.get("result"); //msg -> result
           String Trans =Result.get("translatedText").toString(); //JSon:translatedText -> String
           Trans=Trans.replaceAll("\\\"","");  // String ����ǥ ����
           return Trans;
           
       } catch (Exception e) {
           System.out.println(e);
           return " ";
       }
   }

}
 
