//francisco vazquez Delgaodo
package pkg15460139.analizador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class menu extends javax.swing.JFrame {
    
    JFileChooser seleccionar=new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    
    
     String [] lenguaje={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                         "0","1","2","3","4","5","6","7","8","9",".","_","$","+","-","*","/","=","!","<",">",";",",","{","}","[",
                         "]","(",")"," ","10","#"}; 
     
       int [] lenguajeA={97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,
                      65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,
                      48,49,50,51,52,53,54,55,56,57,46,95,36,43,45,42,47,61,33,60,62,59,44,123,125,91,93,40,41,34,
                      9,32,10,35,00};
       
        int [] posicion={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
                        1,1,1,1,1,1,1,1,1,1,2,3,3,4,5,6,7,8,9,10,10,11,11,
                        12,12,12,12,12,12,12,13,13,14,15,16,16,17};
        
        int [] renglon={0,101,4,8,10,9,26,102,13,12,23,25,2,19,100,5,31,27,14,21,20,6,32,33};//este vector contiene los la posicion de los estados dentro de la matriz
        
         String [] tipo={"Id","Id","Numero","Numero","Clases","Clases","Operador Aritmetico","Operador Aritmetico","Operador Aritmetico","Operador Aritmetico","Cometario","Comentario",
                      "Comentario","Operador Logico","Operador Logico","Asignacion","Asignacion","Separador","Agrupadores","Signo igual"};
          int [] tipoN={101,2,4,6,20,21,8,10,9,26,27,3,31,12,14,13,16,23,25,102};//Este vector contiene numero del estado en el mismo orden que en el del nombre del comportamiento, el vector de arriba
   
          
             String [] reservadas2 = {"int ", "String ", "char ", "public ", "package ", "static ", "java.util.Scanner ", "import ", "class ",
        "switch ", "case ", "break ", "default ", "return ", "void ", "main ", "args ", "new ", "Scanner ", "new ", "System.in ", "System.out.println ", "do ", "while ", "for ", "if ", "else ", "nextInt "};
        
        String [] reservadas={"int","String","char","public","package","static","java.util.Scanner","import","class","switch","case","break","default","return","void","main","args","new","Scanner",
                             "new","System.in","System.out.println","do","while","for","if","else","nextInt"};
        int[][] matriz
            = {{101, 4, 23, -1, 8, 10, 9, 26, 102, 13, 12, 23, 25, 0, 0, -1},//0
            {101, 2, 19, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//1
            {-1, 4, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//2
            {-1, -1, -1, -1, 9, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//3
            {-1, -1, -1, -1, -1, 9, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//4
            {-1,-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//5
            {-1, -1, -1, -1, -1, -1, 31, 27, -1, -1, -1, -1, -1, 100, 100, -1},//6
            {-1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, 100, 100, -1},//7
            {-1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, -1, -1, -1},//8
            {-1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, -1, -1, 100, 100, -1},//9
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//10
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//11
            {2, 2, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//12
            {21, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1},//13
            {101, 4, -1,-1, 8, 10, 9, 26, 102, 13, 12, 23, 25, 0, 0, -1},//14
            {-1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//15
            {-1, -1, -1, -1, -1, -1, 32, -1, -1, -1, -1, -1, -1, -1, -1, 31},//16
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 27},//17 donde tenia 27 habia un -1
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100,100, -1},//18
            {21, -1, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//19
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//20
            {-1, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1},//21
            {-1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, 31},//22
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, 100, -1}};//23
        int estado;  
        int columna;
        int pos;
        char caracter;
        int numero;
        String cadena;
        int Anterior;
    public menu() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea2 = new javax.swing.JTextArea();
        btnCalcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArea1.setColumns(20);
        txtArea1.setRows(5);
        jScrollPane1.setViewportView(txtArea1);

        txtArea2.setColumns(20);
        txtArea2.setRows(5);
        jScrollPane2.setViewportView(txtArea2);

        btnCalcular.setText("Calcular");
        btnCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCalcularMouseClicked(evt);
            }
        });

        jLabel1.setText("Instituto Tecnologico de Colima");

        jLabel2.setText("Lenguajes y autómatas I");

        jLabel3.setText("Departamento de Sistemas y Computación");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setText("Analizador Lexico");

        jLabel5.setText("Ingrese texto: ");

        jLabel6.setText("Francisco Vazquez Delgado");

        jLabel7.setText("No. 15460139");

        btnAbrir.setText("Abrir");
        btnAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirMouseClicked(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(70, 70, 70))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(btnCalcular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(btnAbrir)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalcularMouseClicked
        // Boton Calcular
        String texto=txtArea1.getText();
        Proceso(texto);
    }//GEN-LAST:event_btnCalcularMouseClicked

    private void btnAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirMouseClicked
        // Boton abrir
         if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String documento=abrirArchivo(archivo);
                    txtArea1.setText(documento);
                }else{
                    JOptionPane.showMessageDialog(null, "No se puedo abrir el archivo");
                }
            }
        }
    }//GEN-LAST:event_btnAbrirMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // boton guradar
        if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String Documento=txtArea1.getText();
                String mensaje= guardarArchivo(archivo,Documento);
                if(mensaje!=null){
                    JOptionPane.showMessageDialog(null, mensaje);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Guardar documeto de texto");
            }
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        // Boton Limpiar
        txtArea1.setText(null);
        txtArea2.setText(null);
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // Boton Salir
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }
void Proceso(String Texto){
    estado=0;
    pos=0;
    cadena="";
    do {
        
     
         try {
           caracter=Texto.charAt(pos);//Analizamos caracter por caracter
          
          }catch (Exception e){
             
              break;
          }
         cadena=cadena+caracter;
        System.out.println("Valor del caracter :"+caracter);
        System.out.println("Valor del cadena: "+cadena);
        pos++;//incrrementamos para poder recorrer la cedena Texto
        numero=ConvertirAssci(caracter);
        System.out.println("valor del numero assci "+numero);
        numero=PosicionVectorSimbolos(numero);
        System.out.println("Valor de vectorSimbolos : "+numero);
        columna=posicion[numero];
        System.out.println("Valor de la columna : "+columna);
        Anterior=estado;
        if(estado != -1 && columna != -1)
        {
        estado=matriz[Renglon(estado)][columna];
            System.out.println("Valor del estado : "+estado);   
            if(estado==-1){
                estado=Anterior;
            
            }
        }
        if(estado==100)
        {
          if(PalabrasReservadas(cadena.replaceAll("\\s",""))){
           txtArea2.setText(txtArea2.getText()+"Palabra Reservada"+" : "+cadena+"\n");//Imprimimos el rsultado del primera cadena esto nos indica que hubo espacio o enter
          }else {
      
              System.out.println("El valor del estado es "+Tipo(Anterior));
            txtArea2.setText(txtArea2.getText()+Tipo(Anterior)+" : "+cadena+"\n");
          }
         
         estado=0;   
         cadena="";   
        }
       
    } while (estado!=1 && columna!=-1);
    
    
    
    
    
    
}
 int ConvertirAssci(char caracter){
        /*Esta funcion convierte un caractera a su equivalente en codigo assci*/
        return (int) caracter;
    }
  int PosicionVectorSimbolos(int acsii){
            /*Lo que se busca en esta funcion es dado un caracter convertirlo en codigo ascii, buscar la posicion en el vector de simbolos en  en codigo asci*/
            for(int i=0; i<lenguajeA.length; i++){
                if(acsii==lenguajeA[i]){
                    return i;
                }
                    
            }
            return 85;
        }
   int Renglon(int numero){
        /*Nos devuelve la posicion de un estado dentro de la matriz*/
        for(int i=0; i<renglon.length; i++){
            if(numero==renglon[i]){
                return i;
            }
            
        }
        return -1;
    }
   String Tipo(int numero){
            //Tenemos dos vectores uno con los valores de aceptacion y otro en la misma sintonia pero con el nombre de dichos valores de aceptacion y retorna el nombre del valor de aceptacion por medio del la posicion
            for(int i=0; i<tipoN.length; i++){
                if(numero==tipoN[i]){
                    return tipo[i];
                }
            }
            
            return "(simbolo invalido)";
        }
    boolean PalabrasReservadas(String palabra){
            for(int i=0; i<reservadas.length; i++){
                if(palabra.equals(reservadas[i])){
                    return true;
                }
            }
        return false;
       }
      public String abrirArchivo(File archivo){
        String documento="";
        try{
            entrada=new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read())!=-1){
                char caracter= (char)ascci;
                documento+=caracter;
            }
        }catch(Exception e){
            
        }
        return documento;
    }
       public String guardarArchivo(File archivo,String documento){
        String mensaje=null;
        try{
            salida=new FileOutputStream(archivo);
            byte[] bytxt=documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo Guardado";
        }catch (Exception e){
            
        }
        return mensaje;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtArea1;
    private javax.swing.JTextArea txtArea2;
    // End of variables declaration//GEN-END:variables
}
