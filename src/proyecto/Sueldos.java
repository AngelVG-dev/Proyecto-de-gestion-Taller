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
public class Sueldos extends javax.swing.JInternalFrame {

    ResultSet rs, rs2;
    Statement st, st2;
    String estado = "";

    private void conexion() {
        Connection cn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallerM", "root", "123a");
            //agrego los estos set para que pueda agregar selecionar los siguientes datos, y para pueda leer más consultas en la base de datos
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        st2 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de Driver", "BD", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL" + e.toString(), "BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Sueldos() {
        initComponents();
        conexion();
        MostrarTabla();
        idEmpleado();
        try {
            String sql = "select * from sueldos";
            rs = st.executeQuery(sql);
            rs2= st2.executeQuery(sql);
            if (rs.next()) {

                txtHoras_T.setText(rs.getString("horas_Trabajadas"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo mostrar la tabla" + e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUltimo = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPrimero = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        txtHoras_T = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        box_noEmp = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Sueldos");

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

        jLabel7.setText("Nombre del empleado");

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

        jLabel1.setText("horas_Trabajadas");

        btnPrimero.setText("|<");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        txtHoras_T.setText("Ingrese horas trabajadas del empleado");
        txtHoras_T.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoras_TFocusLost(evt);
            }
        });
        txtHoras_T.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHoras_TMousePressed(evt);
            }
        });
        txtHoras_T.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoras_TKeyTyped(evt);
            }
        });

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFactura);

        box_noEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_noEmpActionPerformed(evt);
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
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(box_noEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHoras_T, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar)
                            .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimero)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente)
                    .addComponent(btnUltimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnModificar)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar)
                            .addComponent(btnConsultar)
                            .addComponent(btnSalir))
                        .addGap(490, 490, 490))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(498, 498, 498))))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(box_noEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoras_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarTabla() {
        try {
            String sql = "Select * from sueldos";
            rs = st.executeQuery(sql);

            Object fila[] = new Object[5];
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("idSueldos");
            modelo.addColumn("idEmpleado");
            modelo.addColumn("horas_Trabajadas");
            modelo.addColumn("Sub_total");
            modelo.addColumn("sueldo_final");

            if (!rs.isBeforeFirst()) {
                rs.beforeFirst();
            }
            while (rs.next()) {
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            tablaFactura.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "No se pudo mostrar la tabla" + e.toString());
        }
    }

    private void idEmpleado() {
        try {

            Statement st1 = null;
            String sql = "Select * from Empleado";
            rs = st.executeQuery(sql);
            if (!rs.isBeforeFirst()) {
                rs.beforeFirst();
            }
            while (rs.next()) {

                box_noEmp.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de SQL" + e.toString(), "BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    double sub_total = 0.0;
    double total = 0.0;


    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        try {
            //metodo de ultimo registro para que lo ponga en lo
            rs.last();
            //poner todos los registro que tiene la tabla en los campos de entrada

            txtHoras_T.setText(rs.getString("horas_Trabajadas"));
            
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
        txtHoras_T.setText("");

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
        String nombre = (String) box_noEmp.getSelectedItem();
        String id = "";
        if (estado.equals("n")) {
            btnCancelar.doClick();
            try {
                String querty = "select * from empleado where nombre ='" + nombre + "'";
                String cargo = "";
                rs = st.executeQuery(querty);
                if (rs.next()) {
                    cargo = rs.getString("cargo");
                    id = rs.getString("idEmpleado");
                }
                switch (cargo) {
                    case "Gerente":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 200;
                        total = sub_total * 0.84;
                        break;
                    case "Administrativo":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 175;
                        total = sub_total * 0.84;
                        break;
                    case "Mecanico":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 150;
                        total = sub_total * 0.84;
                        break;
                    case "Limpieza":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 100;
                        total = sub_total * 0.84;
                        break;
                }
                String sql = "insert into sueldos (idEmpleado, horas_Trabajadas, Sub_total, sueldo_final) "
                        + "values('" + id + "','" + txtHoras_T.getText() + "','" + sub_total + "','" + total + "')";
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
                String querty = "select * from empleado where nombre ='" + nombre + "'";
                String cargo = "";
                rs = st.executeQuery(querty);
                if (rs.next()) {
                    cargo = rs.getString("cargo");
                    id = rs.getString("idEmpleado");
                }
                switch (cargo) {
                    case "Gerente":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 200;
                        total = sub_total * 0.84;
                        break;
                    case "Administrativo":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 175;
                        total = sub_total * 0.84;
                        break;
                    case "Mecanico":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 150;
                        total = sub_total * 0.84;
                        break;
                    case "Limpieza":
                        sub_total = Double.parseDouble(txtHoras_T.getText()) * 100;
                        total = sub_total * 0.84;
                        break;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error, no se pudo guardar el registro" + ex.toString());
                System.out.println(ex);
            }

            try {
                //Toma el expediente del cuadro de texto txtExpediente y ese es el usuario que modificar
                String sql = "update Sueldos set horas_Trabajadas='" + txtHoras_T.getText()
                        + "', Sub_total='" +sub_total
                        + "', sueldo_final='" + total
                        + "' where idEmpleado=" + "'" + id + "'";

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
        String nombre = (String) box_noEmp.getSelectedItem();
        String id = "";
        try {
            String querty = "select * from empleado where nombre ='" + nombre + "'";
            rs = st.executeQuery(querty);
            if (rs.next()) {
                id = rs.getString("IdEmpleado");
            }
            int op = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el registro que se muestra actualmente con el numero de usuario " + id + "?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                st.execute("delete from sueldos where idEmpleado='" + id + "'");
                btnCancelar.doClick();
                MostrarTabla();
                //if(rs.last()){
                String sql = "select * from sueldos";
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    txtHoras_T.setText(rs.getString("horas_Trabajadas"));

                } else {
                    txtHoras_T.setText("");

                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String id = JOptionPane.showInputDialog("Escribe el número de id del sueldo que quieres buscar");
        try {
            String sql = "select * from sueldos where idSueldos=" + id;
            rs = st.executeQuery(sql);
            if (rs.next()) {
                txtHoras_T.setText(rs.getString("horas_Trabajadas"));
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

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        try {
            //seleccionamos antes del primero
            rs.beforeFirst();
            //ahora lo ponemos en el primero
            rs.next();
            //obtemos los datos que tiene

            txtHoras_T.setText(rs.getString("horas_Trabajadas"));
            
              String querty = "select * from empleado where idempleado ='" + rs.getString("Idempleado") +"'";
              rs2=st2.executeQuery(querty);
              if(rs2.next()){
              box_noEmp.setSelectedItem(rs2.getString("Nombre"));
              }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            txtHoras_T.setText(rs.getString("horas_Trabajadas"));
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

    private void txtHoras_TMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoras_TMousePressed
        if (txtHoras_T.getText().equals("Ingrese horas trabajadas del empleadoo")) {
            txtHoras_T.setText("");
            txtHoras_T.setForeground(Color.black);
        }

    }//GEN-LAST:event_txtHoras_TMousePressed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        try {
            //utilizo el metodo para ponerlo en siguiente
            rs.next();
            txtHoras_T.setText(rs.getString("horas_Trabajadas"));
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

    private void tablaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacturaMouseClicked
        DefaultTableModel modelo = (DefaultTableModel) tablaFactura.getModel();
        String id = (String.valueOf(modelo.getValueAt(tablaFactura.getSelectedRow(), 1)));
        try {
            String sql = "select * from empleado where idEmpleado ='" + id + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                box_noEmp.setSelectedItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }
        txtHoras_T.setText(String.valueOf(modelo.getValueAt(tablaFactura.getSelectedRow(), 2)));


    }//GEN-LAST:event_tablaFacturaMouseClicked

    private void txtHoras_TFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoras_TFocusLost
        if (txtHoras_T.getText().trim().equals("Ingrese el pago por hora del empleado")) {
            JOptionPane.showMessageDialog(this, "No dejes el campo vacio");
            txtHoras_T.requestFocus();
            txtHoras_T.setBackground(Color.red);
        } else {
            txtHoras_T.setBackground(Color.white);
        }
    }//GEN-LAST:event_txtHoras_TFocusLost

    private void txtHoras_TKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoras_TKeyTyped
        //declaromos el caracter
        //tomamos el caracter 
        char lt = evt.getKeyChar();
        //verificamos que sea un numero de 0 y 9, para que nomas podemos datos enteros
        if ((lt < '0' || lt > '9')) //filtra los caracteres 
        {
            evt.consume();
        }

      }//GEN-LAST:event_txtHoras_TKeyTyped

    private void box_noEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_noEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_noEmpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTextField txtHoras_T;
    // End of variables declaration//GEN-END:variables
}
