
package proyecto;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */
public class Servicio extends javax.swing.JInternalFrame {

     ResultSet rs, rs2, rs3;
    Statement st,st2,st3;
    String estado = "";
    

      private void conexion() {
        Connection cn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallerM", "root", "123a");
            //agrego los estos set para que pueda agregar selecionar los siguientes datos, y para pueda leer más consultas en la base de datos
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st2 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            st3 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de Driver", "BD", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL" + e.toString(), "BD", JOptionPane.ERROR_MESSAGE);
        }
    }


      String Servicio_s = "";
    int Puesto_Index = 0;

      
    public Servicio() {
        initComponents();
     
        conexion();
        MostrarTabla();
           idAuto();
           idEmpleado();
        try {
            String sql = "select * from servicio";
            rs = st.executeQuery(sql);
            rs2 = st2.executeQuery(sql);
            rs3 = st3.executeQuery(sql);
            if (rs.next()) {
                
                boxServicios.setSelectedIndex(Puesto_Index);
                txtFecha.setText(rs.getString("Fecha_Entrega"));
 
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo mostrar la tabla -Inicio-" + e.toString());
        }

    }
    
        private void MostrarTabla() {
        try {
            String sql = "Select * from servicio";
            rs = st.executeQuery(sql);

            Object fila[] = new Object[5];
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("No_Servicio");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Fecha_Entrega");
            modelo.addColumn("idAuto");
            modelo.addColumn("IdEmpleado");

            if (!rs.isBeforeFirst()) {
                rs.beforeFirst();
            }
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            tablaServicio.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo mostrar la tabla" + e.toString());
        }
    }
    
    
      private void ob_Puesto() {
        int Puesto = this.boxServicios.getSelectedIndex();
        switch (Puesto) {
            case 0:
                Servicio_s = "Cambio de llanta";
                Puesto_Index = 0;
                break;
            case 1:
                Servicio_s = "Cambio de aceite";
                Puesto_Index = 1;
                break;
            case 2:
                Servicio_s = "Cambio de banda";
                Puesto_Index=2;
                break;
            case 3:
                Servicio_s = "Afinacion";
                Puesto_Index = 3;
                break;
            case 4:
                Servicio_s = "Calibracion de las llantas";
                Puesto_Index=4;
                break;
        }
    }
      
   private void idAuto(){
       try{
           
       Statement st1 = null;
       String sql="Select * from auto";
       rs=st.executeQuery(sql);
       if(!rs.isBeforeFirst()){
           rs.beforeFirst();
       }
       while(rs.next()){
           
           box_noAuto.addItem(rs.getString("placa"));
       }
       }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL" + e.toString(), "BD", JOptionPane.ERROR_MESSAGE);
        }
    }
   
   
       private void idEmpleado(){
       try{ 
       Statement st12 = null;
       String sql2="Select * from Empleado";
       rs=st.executeQuery(sql2);
       if(!rs.isBeforeFirst()){
           rs.beforeFirst();
       }
       while(rs.next()){
           
           box_noEmp.addItem(rs.getString("Nombre"));
       }
       }catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL" + e.toString(), "BD", JOptionPane.ERROR_MESSAGE);
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

        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicio = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        boxServicios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        box_noAuto = new javax.swing.JComboBox<>();
        box_noEmp = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Servicio");
        setPreferredSize(new java.awt.Dimension(1376, 786));

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setText(">|");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripcion");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tablaServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicio);

        jLabel2.setText("Fecha de Entrega");

        txtFecha.setText("Ingrese la fecha");
        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFocusLost(evt);
            }
        });
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFechaMousePressed(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        boxServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cambio de llanta", "Cambio de aceite", "Cambio de banda", "Afinacion", "Calibracion de las llantas" }));
        boxServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxServiciosActionPerformed(evt);
            }
        });

        jLabel3.setText("Placa del auto");

        jLabel5.setText("Nombre del empleado");

        btnPrimero.setText("|<");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(box_noAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(box_noEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(17, 17, 17)
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir))
                            .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(box_noAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(box_noEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente)
                    .addComponent(btnUltimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo)
                        .addComponent(btnModificar)
                        .addComponent(btnCancelar)
                        .addComponent(btnGuardar)
                        .addComponent(btnConsultar)
                        .addComponent(btnSalir))
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try {
            //utilizo el metodo para ponerlo en siguiente
            rs.next();

                boxServicios.setSelectedItem(rs.getString("Descripcion"));
                txtFecha.setText(rs.getString("Fecha_Entrega"));
                
              String querty2 = "select * from auto where IdAuto ='" + rs.getString("IdAuto") +"'";
              rs3=st3.executeQuery(querty2);
              if(rs3.next()){
              box_noAuto.setSelectedItem(rs3.getString("Placa"));
              }
                
              String querty = "select * from empleado where idempleado ='" + rs.getString("Idempleado") +"'";
              rs2=st2.executeQuery(querty);
              if(rs2.next()){
              box_noEmp.setSelectedItem(rs2.getString("Nombre"));
              }
              


            if (rs.isLast()) //si esta en el ultimo registro  si esta en el ultimo, si esta
            //en el ultimo entonces lo que hago es mandalo al antepeultimo
            {
                rs.beforeFirst();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        try {
            //metodo de ultimo registro para que lo ponga en lo
            rs.last();
            //poner todos los registro que tiene la tabla en los campos de entrada

                boxServicios.setSelectedItem(rs.getString("Descripcion"));
                txtFecha.setText(rs.getString("Fecha_Entrega"));
                
              String querty2 = "select * from auto where IdAuto ='" + rs.getString("IdAuto") +"'";
              rs3=st3.executeQuery(querty2);
              if(rs3.next()){
              box_noAuto.setSelectedItem(rs3.getString("Placa"));
              }
                
              String querty = "select * from empleado where idempleado ='" + rs.getString("Idempleado") +"'";
              rs2=st2.executeQuery(querty);
              if(rs2.next()){
              box_noEmp.setSelectedItem(rs2.getString("Nombre"));
              }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnConsultar.setEnabled(false);
        estado = "n";

        txtFecha.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnConsultar.setEnabled(false);
        estado = "m";
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = "";
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnConsultar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ob_Puesto();
        
        String auto = (String )box_noAuto.getSelectedItem();
        String id = "";
        
        String emp = (String )box_noEmp.getSelectedItem();
        String idEmp = "";

        if (estado.equals("n")) {
            btnCancelar.doClick();
            try {
                //obtener placa
                String querty = "select * from auto where placa ='" + auto +"'";
                rs=st.executeQuery(querty);
                    if(rs.next()){
                    id= rs.getString("idAuto");
                }

                String sql2 = "select * from empleado where nombre='"+emp +"'";
                rs=st.executeQuery(sql2);
                if(rs.next()){
                    idEmp= rs.getString("idEmpleado");
                }
                
                
                String sql = "insert into servicio (Descripcion, Fecha_Entrega, idAuto, IdEmpleado) "
                + "values('" + Servicio_s + "','" + txtFecha.getText() + "','"
                 + id + "','" + idEmp + "')";
                st.execute(sql);
                JOptionPane.showMessageDialog(this, "Registro Guardado ");
                MostrarTabla();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error, no se pudo guardar el registro" + ex.toString());
                System.out.println(ex);
            }
        }
        if (estado.equals("m")) {
            try {
                                //obtener placa
                String querty = "select * from auto where placa ='" + auto +"'";
                rs=st.executeQuery(querty);
                    if(rs.next()){
                    id= rs.getString("idAuto");
                }

                String sql2 = "select * from empleado where nombre='"+emp +"'";
                rs=st.executeQuery(sql2);
                if(rs.next()){
                    idEmp= rs.getString("idEmpleado");
                }
                //Toma el expediente del cuadro de texto txtExpediente y ese es el usuario que modifica
                System.out.println(id);
                String sql = "update servicio set Descripcion='" + Servicio_s
                + "', Fecha_Entrega='" + txtFecha.getText()
                + "', idAuto='" + id    
                +"' where IdEmpleado="+idEmp;

                st.execute(sql);
                JOptionPane.showMessageDialog(this, "Registro Modificado");
                MostrarTabla();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ocurrio un error y no se pudo modificar el registro" + ex.toString());
            }
            btnCancelar.doClick();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String auto = (String )box_noAuto.getSelectedItem();
        String id = "";
        
        try {
        String querty = "select * from auto where placa ='" + auto +"'";
        rs=st.executeQuery(querty);
        if(rs.next()){
        id= rs.getString("idAuto");
                }
        
            int op = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el servicio con el id del Auto " + id+ "?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                st.execute("delete from servicio where idAuto='" + id + "'");
                btnCancelar.doClick();
                MostrarTabla();
                //if(rs.last()){
                    String sql = "select * from servicio";
                    rs = st.executeQuery(sql);
                    if (rs.next()) {
                        boxServicios.setSelectedIndex(Puesto_Index);
                        txtFecha.setText(rs.getString("Descripcion"));
                    } else {
                    txtFecha.setText("");
                    }

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error " + ex.toString());
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServicioMouseClicked
    DefaultTableModel modelo = (DefaultTableModel) tablaServicio.getModel();

            txtFecha.setText(String.valueOf(modelo.getValueAt(tablaServicio.getSelectedRow(), 2)));
        switch (String.valueOf(modelo.getValueAt(tablaServicio.getSelectedRow(), 1))) {
            case "Cambio de llanta":
            boxServicios.setSelectedIndex(0);
            break;
            case "Cambio de aceite":
            boxServicios.setSelectedIndex(1);
            break;
            case "Cambio de banda":
            boxServicios.setSelectedIndex(2);
            break;
            case "Afinacion":
            boxServicios.setSelectedIndex(3);
            break;
            case "Calibracion de las llantas":
            boxServicios.setSelectedIndex(4);
         
        }
        
     String idAu= (String.valueOf(modelo.getValueAt(tablaServicio.getSelectedRow(), 3)));
     String idEm= (String.valueOf(modelo.getValueAt(tablaServicio.getSelectedRow(), 4)));

        try{
            String sql = "select * from auto where idAuto ='" + idAu +"'";
            rs=st.executeQuery(sql);
            if(rs.next()){
                box_noAuto.setSelectedItem(rs.getString("Placa"));
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
        
        try{
             String sql2 = "select * from empleado where idEmpleado ='" +idEm+"'";
            rs=st.executeQuery(sql2);
            if(rs.next()){
                box_noEmp.setSelectedItem(rs.getString("Nombre"));
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
        


    }//GEN-LAST:event_tablaServicioMouseClicked

    private void txtFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMousePressed
        if (txtFecha.getText().equals("Ingrese la fecha")) {
            txtFecha.setText("");
            txtFecha.setForeground(Color.black);
        }

    }//GEN-LAST:event_txtFechaMousePressed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
    }//GEN-LAST:event_txtFechaActionPerformed

    private void boxServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxServiciosActionPerformed
    }//GEN-LAST:event_boxServiciosActionPerformed

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        ob_Puesto();
        try {
            //seleccionamos antes del primero
            rs.beforeFirst();
            //ahora lo ponemos en el primero
            rs.next();
            //obtemos los datos que tiene

                boxServicios.setSelectedItem(rs.getString("Descripcion"));
                txtFecha.setText(rs.getString("Fecha_Entrega"));
                
                String querty2 = "select * from auto where IdAuto ='" + rs.getString("IdAuto") +"'";
                rs3=st3.executeQuery(querty2);
                if(rs3.next()){
                box_noAuto.setSelectedItem(rs3.getString("Placa"));
                }
                
                String querty = "select * from empleado where idempleado ='" + rs.getString("Idempleado") +"'";
                rs2=st2.executeQuery(querty);
                if(rs2.next()){
                box_noEmp.setSelectedItem(rs2.getString("Nombre"));
                }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        try {
            //verifico si no es esta en el primer registro en
            if (!rs.isFirst()) {
                //si lo no lo esta le resto uno y ahora va quedar en el antterior
                rs.absolute(rs.getRow() - 1);
                //si esta en el primer registro entonces lo mando al ultimo registro
            } else {
                //utilizo el metodo .last para que quede en el ultimo registro
                rs.last();
            }
            //traemos los datos que tiene los campos de entrada

                boxServicios.setSelectedItem(rs.getString("Descripcion"));
                txtFecha.setText(rs.getString("Fecha_Entrega"));
                
              String querty2 = "select * from auto where IdAuto ='" + rs.getString("IdAuto") +"'";
              rs3=st3.executeQuery(querty2);
              if(rs3.next()){
              box_noAuto.setSelectedItem(rs3.getString("Placa"));
              }
                
              String querty = "select * from empleado where idempleado ='" + rs.getString("Idempleado") +"'";
              rs2=st2.executeQuery(querty);
              if(rs2.next()){
              box_noEmp.setSelectedItem(rs2.getString("Nombre"));
              }

        } catch (SQLException e) {
            //mandamos el mensaje del error
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void txtFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusLost
         if (txtFecha.getText().trim().equals("Ingrese la fecha")) {
            JOptionPane.showMessageDialog(this, "No dejes el campo vacio");
            txtFecha.requestFocus();
            txtFecha.setBackground(Color.red);
        } else {
            txtFecha.setBackground(Color.white);
        } 
    }//GEN-LAST:event_txtFechaFocusLost

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String id = JOptionPane.showInputDialog("Escribe el número del servicio que deseas buscar");
        try {
            String sql = "select * from servicio where No_Servicio=" + id;
            rs = st.executeQuery(sql);
            if (rs.next()) {

                boxServicios.setSelectedItem(rs.getString("Descripcion"));
                txtFecha.setText(rs.getString("Fecha_Entrega"));
                
               String querty2 = "select * from auto where IdAuto ='" + rs.getString("IdAuto") +"'";
              rs3=st3.executeQuery(querty2);
              if(rs3.next()){
              box_noAuto.setSelectedItem(rs3.getString("Placa"));
              }
                
              String querty = "select * from empleado where idempleado ='" + rs.getString("Idempleado") +"'";
              rs2=st2.executeQuery(querty);
              if(rs2.next()){
              box_noEmp.setSelectedItem(rs2.getString("Nombre"));
              }

            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el registro");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de base de datos");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxServicios;
    private javax.swing.JComboBox<String> box_noAuto;
    private javax.swing.JComboBox<String> box_noEmp;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaServicio;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
