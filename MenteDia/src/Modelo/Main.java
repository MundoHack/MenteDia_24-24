/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Modelo;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSet;


/**
 *
 * @author Andres Gordillo
 */
public class  Main extends javax.swing.JPanel {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        cargarDatosEnTabla();
        startClock();
    }

      public static void main(String[] args) {
        // Crear una instancia de la interfaz de usuario
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear un nuevo frame para la aplicación
                javax.swing.JFrame frame = new javax.swing.JFrame("Organizador de Ideas");
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                
                // Agregar la instancia del panel Main
                frame.add(new Main());
                
                // Ajustar el tamaño y hacer visible la ventana
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
      
 private void startClock() {
    // Formato de fecha y hora con segundos
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy | HH:mm:ss");

    // Timer que se ejecuta cada segundo (1000 milisegundos)
    Timer timer = new Timer(1000, e -> {
        // Obtener la fecha y hora actual
        Date now = new Date();
        // Formatear la fecha y hora con segundos
        String currentTime = sdf.format(now);
        // Establecer el texto en jLabel2
        jLabel2.setText(currentTime);
    });

    // Ejecutar la primera actualización inmediatamente
    timer.setInitialDelay(0);
    timer.start();
}

 private void cargarDatosEnTabla() {
    // Modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    
    // Columnas de la tabla (según la nueva estructura de la base de datos)
    model.addColumn("ID");
    model.addColumn("Fecha");
    model.addColumn("Idea");
    model.addColumn("Importancia");
    model.addColumn("Entrega");
    model.addColumn("Sitio");
    model.addColumn("Finalizadas");
    model.addColumn("Detalle");

    // Conectar con la base de datos
    String url = "jdbc:mysql://localhost:3306/bd-ideas?useSSL=false&serverTimezone=UTC"; 
    String user = "root";  // Cambia por tu usuario
    String password = "";  // Cambia por tu contraseña
    
    String sql = "SELECT * FROM tabideas"; // Consulta SQL para obtener los datos

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        // Iterar sobre los resultados de la consulta
        while (rs.next()) {
            // Obtener los datos de cada columna según la nueva estructura
            int id = rs.getInt("ID");
            String fecha = rs.getString("Fecha");
            String idea = rs.getString("IDEA");
            int importancia = rs.getInt("IMPORTANCIA");
            String entrega = rs.getString("ENTREGA");
            String sitio = rs.getString("SITIO");
            String finalizadas = rs.getString("Finalizadas");
            String detalle = rs.getString("Detalle");

            // Agregar la fila al modelo de la tabla
            model.addRow(new Object[]{id, fecha, idea, importancia, entrega, sitio, finalizadas, detalle});
        }

        // Establecer el modelo en la tabla
        jTable1.setModel(model);

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage());
    }
}


  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 18)); // NOI18N
        jLabel1.setText("Organizador de Ideas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDEA:", "IMPORTANCIA:", "ENTREGA:", "SITIO:"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Control Ideas: "));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder("Escribir Idea:"));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 160, -1));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("Proceso Idea:"));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 160, -1));

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder("Sitio Entrega:"));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 150, -1));

        jSpinner1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nivel Importancia:"));
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 150, 40));

        jLabel2.setText("Fecha:");

        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscador:"));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    
    String idea = jTextField1.getText();
    int importancia = (int) jSpinner1.getValue();
    String entrega = jTextField2.getText();
    String sitio = jTextField3.getText();
    
    // Obtener la fecha y hora desde el jLabel2
    String fecha = jLabel2.getText();
    
    String finalizadas = "No";  // Valor por defecto
    String detalle = "Ninguno";  // Valor por defecto o puede ser otro campo de entrada

    String url = "jdbc:mysql://localhost:3306/bd-ideas?useSSL=false&serverTimezone=UTC";
    String user = "root";  // Cambia por tu usuario
    String password = "";  // Cambia por tu contraseña

    String sql = "INSERT INTO tabideas (Fecha, IDEA, IMPORTANCIA, ENTREGA, SITIO, Finalizadas, Detalle) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, fecha);  // Usamos la hora obtenida del jLabel2
        pstmt.setString(2, idea);
        pstmt.setInt(3, importancia);
        pstmt.setString(4, entrega);
        pstmt.setString(5, sitio);
        pstmt.setString(6, finalizadas);
        pstmt.setString(7, detalle);

        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Idea guardada correctamente.");
            cargarDatosEnTabla();  // Recargar la tabla después de guardar
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage());
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
   
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro para actualizar.");
        return;
    }

    // Obtener los valores de los campos de texto
    String fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // Fecha actual
    String idea = jTextField1.getText();
    int importancia = (int) jSpinner1.getValue();
    String entrega = jTextField2.getText();
    String sitio = jTextField3.getText();
    String finalizadas = "No";  // Valor por defecto o cambiar según tu lógica
    String detalle = "Ninguno";  // Valor por defecto o puede ser otro campo de entrada

    // Obtener la clave única del registro seleccionado (suponiendo que IDEA es única)
    String ideaSeleccionada = jTable1.getValueAt(selectedRow, 1).toString();

    String url = "jdbc:mysql://localhost:3306/bd-ideas?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    String sql = "UPDATE tabideas SET Fecha = ?, IMPORTANCIA = ?, ENTREGA = ?, SITIO = ?, Finalizadas = ?, Detalle = ? WHERE IDEA = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, fecha);
        pstmt.setInt(2, importancia);
        pstmt.setString(3, entrega);
        pstmt.setString(4, sitio);
        pstmt.setString(5, finalizadas);
        pstmt.setString(6, detalle);
        pstmt.setString(7, ideaSeleccionada);

        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "El registro se actualizó correctamente.");
            cargarDatosEnTabla();  // Recargar la tabla después de actualizar
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el registro.");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al actualizar los datos: " + ex.getMessage());
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         // Verificar que se haya seleccionado una fila
   
    // Verificar que se haya seleccionado una fila
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un registro para eliminar.");
        return;
    }

    // Obtener la clave única del registro seleccionado (suponiendo que IDEA es única)
    String ideaSeleccionada = jTable1.getValueAt(selectedRow, 1).toString();

    String url = "jdbc:mysql://localhost:3306/bd-ideas?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    String sql = "DELETE FROM tabideas WHERE IDEA = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, ideaSeleccionada);

        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "El registro se eliminó correctamente.");
            cargarDatosEnTabla();  // Recargar la tabla después de la eliminación
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro.");
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al eliminar los datos: " + ex.getMessage());
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

       // Obtener el índice de la fila seleccionada
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        // Obtener los datos de la fila seleccionada
        String fecha = jTable1.getValueAt(selectedRow, 1).toString(); // Columna Fecha
        String idea = jTable1.getValueAt(selectedRow, 2).toString(); // Columna IDEA
        int importancia = (int) jTable1.getValueAt(selectedRow, 3);  // Columna Importancia
        String entrega = jTable1.getValueAt(selectedRow, 4).toString(); // Columna Entrega
        String sitio = jTable1.getValueAt(selectedRow, 5).toString(); // Columna Sitio
        String finalizadas = jTable1.getValueAt(selectedRow, 6).toString(); // Columna Finalizadas
        String detalle = jTable1.getValueAt(selectedRow, 7).toString(); // Columna Detalle

        // Asignar los valores a los campos de entrada
        jTextField1.setText(idea);
        jTextField2.setText(entrega);
        jTextField3.setText(sitio);
        jSpinner1.setValue(importancia);

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked
    }
    
    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
  
         // Obtener el texto ingresado en el campo de búsqueda
    String searchText = jTextField4.getText();

    // Si el texto de búsqueda está vacío, se cargan todos los datos
    if (searchText.isEmpty()) {
        cargarDatosEnTabla();
        return;
    }
    
    // Conectar con la base de datos
    String url = "jdbc:mysql://localhost:3306/bd-ideas?useSSL=false&serverTimezone=UTC"; 
    String user = "root";  // Cambia por tu usuario
    String password = "";  // Cambia por tu contraseña

    // Consulta SQL para buscar en todas las columnas relevantes
    String sql = "SELECT * FROM tabideas WHERE ID LIKE ? OR Fecha LIKE ? OR IDEA LIKE ? OR SITIO LIKE ? OR ENTREGA LIKE ? OR Finalizadas LIKE ? OR Detalle LIKE ?";

    // Modelo de la tabla
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Fecha");
    model.addColumn("Idea");
    model.addColumn("Importancia");
    model.addColumn("Entrega");
    model.addColumn("Sitio");
    model.addColumn("Finalizadas");
    model.addColumn("Detalle");

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Configurar el parámetro de búsqueda para todas las columnas
        String searchPattern = "%" + searchText + "%";
        pstmt.setString(1, searchPattern);
        pstmt.setString(2, searchPattern);
        pstmt.setString(3, searchPattern);
        pstmt.setString(4, searchPattern);
        pstmt.setString(5, searchPattern);
        pstmt.setString(6, searchPattern);
        pstmt.setString(7, searchPattern);

        // Ejecutar la consulta
        try (ResultSet rs = pstmt.executeQuery()) {

            // Iterar sobre los resultados de la consulta
            while (rs.next()) {
                // Obtener los datos de cada columna
                int id = rs.getInt("ID");
                String fecha = rs.getString("Fecha");
                String idea = rs.getString("IDEA");
                int importancia = rs.getInt("IMPORTANCIA");
                String entrega = rs.getString("ENTREGA");
                String sitio = rs.getString("SITIO");
                String finalizadas = rs.getString("Finalizadas");
                String detalle = rs.getString("Detalle");

                // Agregar la fila al modelo de la tabla
                model.addRow(new Object[]{id, fecha, idea, importancia, entrega, sitio, finalizadas, detalle});
            }

            // Establecer el modelo en la tabla
            jTable1.setModel(model);

        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al buscar los datos: " + ex.getMessage());
    }
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
