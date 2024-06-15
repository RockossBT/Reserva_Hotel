package Vista;

import Controlador.Conexion;
import Modelo.Habitacion;
import java.awt.Dimension;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ifrmListaHabitacion extends javax.swing.JInternalFrame {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    DefaultTableModel modelo;
    String habitacionId;
    Habitacion hab = new Habitacion();
    
    public ifrmListaHabitacion() {
        initComponents();
        mostrarLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        btnAnadir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Listar Habitaciones");

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "Tipo", "N° Habitación", "Piso", "Comentario", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDatos);
        if (tableDatos.getColumnModel().getColumnCount() > 0) {
            tableDatos.getColumnModel().getColumn(0).setMinWidth(50);
            tableDatos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableDatos.getColumnModel().getColumn(0).setMaxWidth(50);
            tableDatos.getColumnModel().getColumn(1).setMinWidth(80);
            tableDatos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableDatos.getColumnModel().getColumn(1).setMaxWidth(80);
            tableDatos.getColumnModel().getColumn(2).setMinWidth(90);
            tableDatos.getColumnModel().getColumn(2).setPreferredWidth(90);
            tableDatos.getColumnModel().getColumn(2).setMaxWidth(90);
            tableDatos.getColumnModel().getColumn(3).setMinWidth(50);
            tableDatos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableDatos.getColumnModel().getColumn(3).setMaxWidth(50);
            tableDatos.getColumnModel().getColumn(4).setMinWidth(350);
            tableDatos.getColumnModel().getColumn(4).setPreferredWidth(350);
            tableDatos.getColumnModel().getColumn(4).setMaxWidth(350);
            tableDatos.getColumnModel().getColumn(5).setMinWidth(60);
            tableDatos.getColumnModel().getColumn(5).setPreferredWidth(60);
            tableDatos.getColumnModel().getColumn(5).setMaxWidth(60);
            tableDatos.getColumnModel().getColumn(6).setMinWidth(120);
            tableDatos.getColumnModel().getColumn(6).setPreferredWidth(120);
            tableDatos.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnHabilitar.setText("Habilitar");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHabilitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadir)
                    .addComponent(btnEditar)
                    .addComponent(btnHabilitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        ifrmAgregarHabitacion habitacion = new ifrmAgregarHabitacion();
        this.getParent().add(habitacion);
        Dimension desktopSize = this.getParent().getSize();
        Dimension FrameSize = habitacion.getSize();
        habitacion.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        habitacion.show();
        habitacion.asignarLista(this);
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tableDatos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una habitacion");
            return;
        }
        ifrmEditarHabitacion habitacion = new ifrmEditarHabitacion();
        this.getParent().add(habitacion);
        Dimension desktopSize = this.getParent().getSize();
        Dimension FrameSize = habitacion.getSize();
        habitacion.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        habitacion.show();
        habitacion.asignarLista(this);
        habitacion.asignarHabitacion(hab);
        habitacion.obtenerHabitacion();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDatosMouseClicked
        int filas = tableDatos.getSelectedRow();
        
        if (filas == -1) {
            JOptionPane.showMessageDialog(null, "Habitacion no seleccionada.");
        } else {
            habitacionId = (String) tableDatos.getValueAt(filas, 0);
            String tipo = (String) tableDatos.getValueAt(filas, 1);
            int nro_habitacion = Integer.parseInt((String) tableDatos.getValueAt(filas, 2));
            int piso = Integer.parseInt((String) tableDatos.getValueAt(filas, 3));
            String comentario = (String) tableDatos.getValueAt(filas, 4);
            int precio = Integer.parseInt((String) tableDatos.getValueAt(filas, 5));
            String estado = (String) tableDatos.getValueAt(filas, 6);
            
            hab = new Habitacion(habitacionId, tipo, comentario, precio, nro_habitacion, piso, estado);
        }
    }//GEN-LAST:event_tableDatosMouseClicked

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        if (tableDatos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una habitacion");
            return;
        }
        String sql = "UPDATE habitacion SET estado='Disponible' WHERE id_habitacion='" + hab.getId_habitacion() + "'";
        
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            
            limpiarTabla();
            mostrarLista();
            JOptionPane.showMessageDialog(null, "Habitacion Habilitada");
        } catch (SQLException e) {
            Logger.getLogger(ifrmEditarHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnHabilitarActionPerformed
    
    public void limpiarTabla() {
        modelo.setRowCount(0);
    }
    
    public void mostrarLista() {
        String sql = "SELECT * FROM habitacion";
        
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] Habitacion = new Object[7];
            modelo = (DefaultTableModel) tableDatos.getModel();
            
            while (rs.next()) {
                Habitacion[0] = rs.getString("id_habitacion");
                Habitacion[1] = rs.getString("tipo");
                Habitacion[2] = rs.getString("nro_habitacion");
                Habitacion[3] = rs.getString("piso");
                Habitacion[4] = rs.getString("comentario");
                Habitacion[5] = rs.getString("precio");
                Habitacion[6] = rs.getString("estado");
                modelo.addRow(Habitacion);
            }
            tableDatos.setModel(modelo);
        } catch (SQLException e) {
            Logger.getLogger(ifrmAgregarHabitacion.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDatos;
    // End of variables declaration//GEN-END:variables
}
