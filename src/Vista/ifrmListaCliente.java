package Vista;

import Controlador.Conexion;
import Modelo.Cliente;
import java.awt.Dimension;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ifrmListaCliente extends javax.swing.JInternalFrame {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    DefaultTableModel modelo;
    String clienteId;
    Cliente cli = new Cliente();
    
    public ifrmListaCliente() {
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

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Listar Clientes");

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "Nombre", "Fecha de Nac", "Telefono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tableDatos.getColumnModel().getColumn(0).setMinWidth(70);
            tableDatos.getColumnModel().getColumn(0).setPreferredWidth(70);
            tableDatos.getColumnModel().getColumn(0).setMaxWidth(70);
            tableDatos.getColumnModel().getColumn(1).setMinWidth(220);
            tableDatos.getColumnModel().getColumn(1).setPreferredWidth(220);
            tableDatos.getColumnModel().getColumn(1).setMaxWidth(220);
            tableDatos.getColumnModel().getColumn(2).setMinWidth(100);
            tableDatos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableDatos.getColumnModel().getColumn(2).setMaxWidth(100);
            tableDatos.getColumnModel().getColumn(3).setMinWidth(120);
            tableDatos.getColumnModel().getColumn(3).setPreferredWidth(120);
            tableDatos.getColumnModel().getColumn(3).setMaxWidth(120);
            tableDatos.getColumnModel().getColumn(4).setMinWidth(300);
            tableDatos.getColumnModel().getColumn(4).setPreferredWidth(300);
            tableDatos.getColumnModel().getColumn(4).setMaxWidth(300);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 626, Short.MAX_VALUE)
                        .addComponent(btnAnadir)
                        .addGap(10, 10, 10)
                        .addComponent(btnEditar))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnadir)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        ifrmAgregarCliente cliente = new ifrmAgregarCliente();
        this.getParent().add(cliente);
        Dimension desktopSize = this.getParent().getSize();
        Dimension FrameSize = cliente.getSize();
        cliente.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        cliente.show();
        cliente.asignarLista(this);
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ifrmEditarCliente cliente = new ifrmEditarCliente();
        this.getParent().add(cliente);
        Dimension desktopSize = this.getParent().getSize();
        Dimension FrameSize = cliente.getSize();
        cliente.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        cliente.show();
        cliente.asignarLista(this);
        cliente.asignarCliente(cli);
        cliente.obtenerCliente();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDatosMouseClicked
        int filas = tableDatos.getSelectedRow();
        
        if (filas == -1) {
            JOptionPane.showMessageDialog(null, "Habitacion no seleccionada.");
        } else {
            clienteId = (String) tableDatos.getValueAt(filas, 0);
            String nombre = (String) tableDatos.getValueAt(filas, 1);
            String fechaNac = (String) tableDatos.getValueAt(filas, 2);
            String telefono = (String) tableDatos.getValueAt(filas, 3);
            String correo = (String) tableDatos.getValueAt(filas, 4);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            try {
                Date fecha_nac = formato.parse(fechaNac);
                cli = new Cliente(clienteId, nombre, fecha_nac, telefono, correo);
            } catch (ParseException e) {
                Logger.getLogger(ifrmListaCliente.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_tableDatosMouseClicked
    
    public void mostrarLista() {
        String sql = "SELECT * FROM cliente";
        
        try {
            cn = Conexion.conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] Usuario = new Object[5];
            modelo = (DefaultTableModel) tableDatos.getModel();
            
            while (rs.next()) {
                Usuario[0] = rs.getString("id_cliente");
                Usuario[1] = rs.getString("nombre");
                Usuario[2] = rs.getString("fecha_nac");
                Usuario[3] = rs.getString("telefono");
                Usuario[4] = rs.getString("correo");
                modelo.addRow(Usuario);
            }
            tableDatos.setModel(modelo);
        } catch (SQLException e) {
            Logger.getLogger(ifrmListaCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void limpiarTabla() {
        modelo.setRowCount(0);
    }
                    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDatos;
    // End of variables declaration//GEN-END:variables
}
