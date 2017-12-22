package com.prop.presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaPartida {
    private JButton checkButton;
    private JButton btnRed;
    private JButton btnGreen;
    private JButton btnBlue;
    private JButton btnOrange;
    private JPanel selectorPanel;
    private JPanel toolsPanel;
    private JPanel playerPanel;
    private JPanel fila0;
    private JPanel fila1;
    private JPanel panelMain;
    private JButton b00;
    private JButton b01;
    private JButton b02;
    private JButton b03;
    private JButton b13;
    private JButton b11;
    private JButton b12;
    private JButton b10;
    private JPanel fila2;
    private JButton b21;
    private JButton b22;
    private JButton b20;
    private JButton b23;
    private JPanel fila3;
    private JButton b30;
    private JButton b31;
    private JButton b32;
    private JButton b33;
    private JButton b42;
    private JButton b40;
    private JButton b41;
    private JPanel fila4;
    private JButton b43;
    private JButton b50;
    private JButton b53;
    private JPanel fila5;
    private JButton b52;
    private JButton b51;
    private JPanel fila6;
    private JButton b63;
    private JButton b60;
    private JButton b62;
    private JButton b61;
    private JButton b71;
    private JButton b72;
    private JPanel fila7;
    private JButton b70;
    private JButton b73;
    private JButton b81;
    private JButton b80;
    private JButton b83;
    private JButton b82;
    private JPanel fila8;
    private JButton b91;
    private JPanel fila9;
    private JButton b92;
    private JButton b90;
    private JButton b93;

    private int editable = 0;
    private Image selected;
    private Color colorSelected;

    public static void main(String[] args) {
        JFrame frame = new JFrame("VistaPartida");
        frame.setContentPane(new VistaPartida().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VistaPartida() {
        $$$setupUI$$$();
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                editable++;
            }
        });
        b00.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 0) {
                    b00.setBackground(colorSelected);
                }
            }
        });
        b01.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 0) {
                    b01.setBackground(colorSelected);
                }
            }
        });
        b02.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 0) {
                    b02.setBackground(colorSelected);
                }
            }
        });
        b03.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 0) {
                    b03.setBackground(colorSelected);
                }
            }
        });
        b10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 1) {
                    b10.setBackground(colorSelected);
                }
            }
        });
        b11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 1) {
                    b11.setBackground(colorSelected);
                }
            }
        });
        b12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 1) {
                    b12.setBackground(colorSelected);
                }
            }
        });
        b13.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 1) {
                    b13.setBackground(colorSelected);
                }
            }
        });
        b20.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 2) {
                    b20.setBackground(colorSelected);
                }
            }
        });
        b21.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 2) {
                    b21.setBackground(colorSelected);
                }
            }
        });
        b22.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 2) {
                    b22.setBackground(colorSelected);
                }
            }
        });
        b23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 2) {
                    b23.setBackground(colorSelected);
                }
            }
        });
        b30.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 3) {
                    b30.setBackground(colorSelected);
                }
            }
        });
        b31.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 3) {
                    b31.setBackground(colorSelected);
                }
            }
        });
        b32.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 3) {
                    b32.setBackground(colorSelected);
                }
            }
        });
        b33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 3) {
                    b33.setBackground(colorSelected);
                }
            }
        });
        b40.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 4) {
                    b40.setBackground(colorSelected);
                }
            }
        });
        b41.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 4) {
                    b41.setBackground(colorSelected);
                }
            }
        });
        b42.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 4) {
                    b42.setBackground(colorSelected);
                }
            }
        });
        b43.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 4) {
                    b43.setBackground(colorSelected);
                }
            }
        });
        b50.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 5) {
                    b50.setBackground(colorSelected);
                }
            }
        });
        b51.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 5) {
                    b51.setBackground(colorSelected);
                }
            }
        });
        b52.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 5) {
                    b52.setBackground(colorSelected);
                }
            }
        });
        b53.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 5) {
                    b53.setBackground(colorSelected);
                }
            }
        });
        b60.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 6) {
                    b60.setBackground(colorSelected);
                }
            }
        });
        b61.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 6) {
                    b61.setBackground(colorSelected);
                }
            }
        });
        b62.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 6) {
                    b62.setBackground(colorSelected);
                }
            }
        });
        b63.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 6) {
                    b63.setBackground(colorSelected);
                }
            }
        });
        b70.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 7) {
                    b70.setBackground(colorSelected);
                }
            }
        });
        b71.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 7) {
                    b71.setBackground(colorSelected);
                }
            }
        });
        b72.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 7) {
                    b72.setBackground(colorSelected);
                }
            }
        });
        b73.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 7) {
                    b73.setBackground(colorSelected);
                }
            }
        });
        b80.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 8) {
                    b80.setBackground(colorSelected);
                }
            }
        });
        b81.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 8) {
                    b81.setBackground(colorSelected);
                }
            }
        });
        b82.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 8) {
                    b82.setBackground(colorSelected);
                }
            }
        });
        b83.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 8) {
                    b83.setBackground(colorSelected);
                }
            }
        });
        b90.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 9) {
                    b90.setBackground(colorSelected);
                }
            }
        });
        b91.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 9) {
                    b91.setBackground(colorSelected);
                }
            }
        });
        b92.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 9) {
                    b92.setBackground(colorSelected);
                }
            }
        });
        b93.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (editable == 9) {
                    b93.setBackground(colorSelected);
                }
            }
        });


        btnRed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                colorSelected = Color.RED;
            }
        });
        btnGreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                colorSelected = Color.GREEN;
            }
        });
        btnBlue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                colorSelected = Color.BLUE;
            }
        });
        btnOrange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                colorSelected = Color.ORANGE;
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        toolsPanel = new JPanel();
        toolsPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(20, 20, 20, 20), -1, -1));
        panelMain.add(toolsPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        checkButton = new JButton();
        checkButton.setText("Check");
        toolsPanel.add(checkButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectorPanel = new JPanel();
        selectorPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        toolsPanel.add(selectorPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnRed = new JButton();
        btnRed.setHorizontalTextPosition(0);
        btnRed.setIcon(new ImageIcon(getClass().getResource("/images/red.png")));
        btnRed.setText("");
        selectorPanel.add(btnRed, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnGreen = new JButton();
        btnGreen.setIcon(new ImageIcon(getClass().getResource("/images/green.png")));
        btnGreen.setText("");
        selectorPanel.add(btnGreen, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnBlue = new JButton();
        btnBlue.setIcon(new ImageIcon(getClass().getResource("/images/blue.png")));
        btnBlue.setText("");
        selectorPanel.add(btnBlue, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnOrange = new JButton();
        btnOrange.setIcon(new ImageIcon(getClass().getResource("/images/orange.png")));
        btnOrange.setText("");
        selectorPanel.add(btnOrange, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        toolsPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        playerPanel = new JPanel();
        playerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(playerPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        fila0 = new JPanel();
        fila0.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(20, 20, 0, 20), -1, -1));
        fila0.setEnabled(true);
        playerPanel.add(fila0, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b00 = new JButton();
        b00.setEnabled(true);
        Font b00Font = this.$$$getFont$$$(null, -1, -1, b00.getFont());
        if (b00Font != null) b00.setFont(b00Font);
        b00.setHideActionText(false);
        b00.setHorizontalTextPosition(0);
        b00.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b00.setText("");
        fila0.add(b00, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b01 = new JButton();
        b01.setEnabled(true);
        Font b01Font = this.$$$getFont$$$(null, -1, -1, b01.getFont());
        if (b01Font != null) b01.setFont(b01Font);
        b01.setHideActionText(false);
        b01.setHorizontalTextPosition(0);
        b01.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b01.setText("");
        fila0.add(b01, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b02 = new JButton();
        b02.setEnabled(true);
        Font b02Font = this.$$$getFont$$$(null, -1, -1, b02.getFont());
        if (b02Font != null) b02.setFont(b02Font);
        b02.setHideActionText(false);
        b02.setHorizontalTextPosition(0);
        b02.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b02.setText("");
        fila0.add(b02, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b03 = new JButton();
        b03.setEnabled(true);
        Font b03Font = this.$$$getFont$$$(null, -1, -1, b03.getFont());
        if (b03Font != null) b03.setFont(b03Font);
        b03.setHideActionText(false);
        b03.setHorizontalTextPosition(0);
        b03.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b03.setText("");
        fila0.add(b03, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila1 = new JPanel();
        fila1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila1.setEnabled(true);
        playerPanel.add(fila1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b10 = new JButton();
        b10.setEnabled(true);
        Font b10Font = this.$$$getFont$$$(null, -1, -1, b10.getFont());
        if (b10Font != null) b10.setFont(b10Font);
        b10.setHideActionText(false);
        b10.setHorizontalTextPosition(0);
        b10.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b10.setText("");
        fila1.add(b10, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b11 = new JButton();
        b11.setEnabled(true);
        Font b11Font = this.$$$getFont$$$(null, -1, -1, b11.getFont());
        if (b11Font != null) b11.setFont(b11Font);
        b11.setHideActionText(false);
        b11.setHorizontalTextPosition(0);
        b11.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b11.setText("");
        fila1.add(b11, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b12 = new JButton();
        b12.setEnabled(true);
        Font b12Font = this.$$$getFont$$$(null, -1, -1, b12.getFont());
        if (b12Font != null) b12.setFont(b12Font);
        b12.setHideActionText(false);
        b12.setHorizontalTextPosition(0);
        b12.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b12.setText("");
        fila1.add(b12, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b13 = new JButton();
        b13.setEnabled(true);
        Font b13Font = this.$$$getFont$$$(null, -1, -1, b13.getFont());
        if (b13Font != null) b13.setFont(b13Font);
        b13.setHideActionText(false);
        b13.setHorizontalTextPosition(0);
        b13.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b13.setText("");
        fila1.add(b13, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila2 = new JPanel();
        fila2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila2.setEnabled(true);
        playerPanel.add(fila2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b20 = new JButton();
        b20.setEnabled(true);
        Font b20Font = this.$$$getFont$$$(null, -1, -1, b20.getFont());
        if (b20Font != null) b20.setFont(b20Font);
        b20.setHideActionText(false);
        b20.setHorizontalTextPosition(0);
        b20.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b20.setText("");
        fila2.add(b20, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b21 = new JButton();
        b21.setEnabled(true);
        Font b21Font = this.$$$getFont$$$(null, -1, -1, b21.getFont());
        if (b21Font != null) b21.setFont(b21Font);
        b21.setHideActionText(false);
        b21.setHorizontalTextPosition(0);
        b21.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b21.setText("");
        fila2.add(b21, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b22 = new JButton();
        b22.setEnabled(true);
        Font b22Font = this.$$$getFont$$$(null, -1, -1, b22.getFont());
        if (b22Font != null) b22.setFont(b22Font);
        b22.setHideActionText(false);
        b22.setHorizontalTextPosition(0);
        b22.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b22.setText("");
        fila2.add(b22, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b23 = new JButton();
        b23.setEnabled(true);
        Font b23Font = this.$$$getFont$$$(null, -1, -1, b23.getFont());
        if (b23Font != null) b23.setFont(b23Font);
        b23.setHideActionText(false);
        b23.setHorizontalTextPosition(0);
        b23.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b23.setText("");
        fila2.add(b23, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila3 = new JPanel();
        fila3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila3.setEnabled(true);
        playerPanel.add(fila3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b30 = new JButton();
        b30.setEnabled(true);
        Font b30Font = this.$$$getFont$$$(null, -1, -1, b30.getFont());
        if (b30Font != null) b30.setFont(b30Font);
        b30.setHideActionText(false);
        b30.setHorizontalTextPosition(0);
        b30.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b30.setText("");
        fila3.add(b30, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b31 = new JButton();
        b31.setEnabled(true);
        Font b31Font = this.$$$getFont$$$(null, -1, -1, b31.getFont());
        if (b31Font != null) b31.setFont(b31Font);
        b31.setHideActionText(false);
        b31.setHorizontalTextPosition(0);
        b31.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b31.setText("");
        fila3.add(b31, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b32 = new JButton();
        b32.setEnabled(true);
        Font b32Font = this.$$$getFont$$$(null, -1, -1, b32.getFont());
        if (b32Font != null) b32.setFont(b32Font);
        b32.setHideActionText(false);
        b32.setHorizontalTextPosition(0);
        b32.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b32.setText("");
        fila3.add(b32, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b33 = new JButton();
        b33.setEnabled(true);
        Font b33Font = this.$$$getFont$$$(null, -1, -1, b33.getFont());
        if (b33Font != null) b33.setFont(b33Font);
        b33.setHideActionText(false);
        b33.setHorizontalTextPosition(0);
        b33.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b33.setText("");
        fila3.add(b33, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila4 = new JPanel();
        fila4.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila4.setEnabled(true);
        playerPanel.add(fila4, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b40 = new JButton();
        b40.setEnabled(true);
        Font b40Font = this.$$$getFont$$$(null, -1, -1, b40.getFont());
        if (b40Font != null) b40.setFont(b40Font);
        b40.setHideActionText(false);
        b40.setHorizontalTextPosition(0);
        b40.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b40.setText("");
        fila4.add(b40, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b41 = new JButton();
        b41.setEnabled(true);
        Font b41Font = this.$$$getFont$$$(null, -1, -1, b41.getFont());
        if (b41Font != null) b41.setFont(b41Font);
        b41.setHideActionText(false);
        b41.setHorizontalTextPosition(0);
        b41.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b41.setText("");
        fila4.add(b41, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b42 = new JButton();
        b42.setEnabled(true);
        Font b42Font = this.$$$getFont$$$(null, -1, -1, b42.getFont());
        if (b42Font != null) b42.setFont(b42Font);
        b42.setHideActionText(false);
        b42.setHorizontalTextPosition(0);
        b42.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b42.setText("");
        fila4.add(b42, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b43 = new JButton();
        b43.setEnabled(true);
        Font b43Font = this.$$$getFont$$$(null, -1, -1, b43.getFont());
        if (b43Font != null) b43.setFont(b43Font);
        b43.setHideActionText(false);
        b43.setHorizontalTextPosition(0);
        b43.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b43.setText("");
        fila4.add(b43, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila5 = new JPanel();
        fila5.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila5.setEnabled(true);
        playerPanel.add(fila5, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b50 = new JButton();
        b50.setEnabled(true);
        Font b50Font = this.$$$getFont$$$(null, -1, -1, b50.getFont());
        if (b50Font != null) b50.setFont(b50Font);
        b50.setHideActionText(false);
        b50.setHorizontalTextPosition(0);
        b50.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b50.setText("");
        fila5.add(b50, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b51 = new JButton();
        b51.setEnabled(true);
        Font b51Font = this.$$$getFont$$$(null, -1, -1, b51.getFont());
        if (b51Font != null) b51.setFont(b51Font);
        b51.setHideActionText(false);
        b51.setHorizontalTextPosition(0);
        b51.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b51.setText("");
        fila5.add(b51, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b52 = new JButton();
        b52.setEnabled(true);
        Font b52Font = this.$$$getFont$$$(null, -1, -1, b52.getFont());
        if (b52Font != null) b52.setFont(b52Font);
        b52.setHideActionText(false);
        b52.setHorizontalTextPosition(0);
        b52.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b52.setText("");
        fila5.add(b52, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b53 = new JButton();
        b53.setEnabled(true);
        Font b53Font = this.$$$getFont$$$(null, -1, -1, b53.getFont());
        if (b53Font != null) b53.setFont(b53Font);
        b53.setHideActionText(false);
        b53.setHorizontalTextPosition(0);
        b53.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b53.setText("");
        fila5.add(b53, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila6 = new JPanel();
        fila6.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila6.setEnabled(true);
        playerPanel.add(fila6, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b60 = new JButton();
        b60.setEnabled(true);
        Font b60Font = this.$$$getFont$$$(null, -1, -1, b60.getFont());
        if (b60Font != null) b60.setFont(b60Font);
        b60.setHideActionText(false);
        b60.setHorizontalTextPosition(0);
        b60.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b60.setText("");
        fila6.add(b60, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b61 = new JButton();
        b61.setEnabled(true);
        Font b61Font = this.$$$getFont$$$(null, -1, -1, b61.getFont());
        if (b61Font != null) b61.setFont(b61Font);
        b61.setHideActionText(false);
        b61.setHorizontalTextPosition(0);
        b61.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b61.setText("");
        fila6.add(b61, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b62 = new JButton();
        b62.setEnabled(true);
        Font b62Font = this.$$$getFont$$$(null, -1, -1, b62.getFont());
        if (b62Font != null) b62.setFont(b62Font);
        b62.setHideActionText(false);
        b62.setHorizontalTextPosition(0);
        b62.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b62.setText("");
        fila6.add(b62, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b63 = new JButton();
        b63.setEnabled(true);
        Font b63Font = this.$$$getFont$$$(null, -1, -1, b63.getFont());
        if (b63Font != null) b63.setFont(b63Font);
        b63.setHideActionText(false);
        b63.setHorizontalTextPosition(0);
        b63.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b63.setText("");
        fila6.add(b63, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila7 = new JPanel();
        fila7.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila7.setEnabled(true);
        playerPanel.add(fila7, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b70 = new JButton();
        b70.setEnabled(true);
        Font b70Font = this.$$$getFont$$$(null, -1, -1, b70.getFont());
        if (b70Font != null) b70.setFont(b70Font);
        b70.setHideActionText(false);
        b70.setHorizontalTextPosition(0);
        b70.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b70.setText("");
        fila7.add(b70, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b71 = new JButton();
        b71.setEnabled(true);
        Font b71Font = this.$$$getFont$$$(null, -1, -1, b71.getFont());
        if (b71Font != null) b71.setFont(b71Font);
        b71.setHideActionText(false);
        b71.setHorizontalTextPosition(0);
        b71.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b71.setText("");
        fila7.add(b71, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b72 = new JButton();
        b72.setEnabled(true);
        Font b72Font = this.$$$getFont$$$(null, -1, -1, b72.getFont());
        if (b72Font != null) b72.setFont(b72Font);
        b72.setHideActionText(false);
        b72.setHorizontalTextPosition(0);
        b72.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b72.setText("");
        fila7.add(b72, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b73 = new JButton();
        b73.setEnabled(true);
        Font b73Font = this.$$$getFont$$$(null, -1, -1, b73.getFont());
        if (b73Font != null) b73.setFont(b73Font);
        b73.setHideActionText(false);
        b73.setHorizontalTextPosition(0);
        b73.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b73.setText("");
        fila7.add(b73, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila8 = new JPanel();
        fila8.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila8.setEnabled(true);
        playerPanel.add(fila8, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b80 = new JButton();
        b80.setEnabled(true);
        Font b80Font = this.$$$getFont$$$(null, -1, -1, b80.getFont());
        if (b80Font != null) b80.setFont(b80Font);
        b80.setHideActionText(false);
        b80.setHorizontalTextPosition(0);
        b80.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b80.setText("");
        fila8.add(b80, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b81 = new JButton();
        b81.setEnabled(true);
        Font b81Font = this.$$$getFont$$$(null, -1, -1, b81.getFont());
        if (b81Font != null) b81.setFont(b81Font);
        b81.setHideActionText(false);
        b81.setHorizontalTextPosition(0);
        b81.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b81.setText("");
        fila8.add(b81, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b82 = new JButton();
        b82.setEnabled(true);
        Font b82Font = this.$$$getFont$$$(null, -1, -1, b82.getFont());
        if (b82Font != null) b82.setFont(b82Font);
        b82.setHideActionText(false);
        b82.setHorizontalTextPosition(0);
        b82.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b82.setText("");
        fila8.add(b82, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b83 = new JButton();
        b83.setEnabled(true);
        Font b83Font = this.$$$getFont$$$(null, -1, -1, b83.getFont());
        if (b83Font != null) b83.setFont(b83Font);
        b83.setHideActionText(false);
        b83.setHorizontalTextPosition(0);
        b83.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b83.setText("");
        fila8.add(b83, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        fila9 = new JPanel();
        fila9.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 20, 0, 20), -1, -1));
        fila9.setEnabled(true);
        playerPanel.add(fila9, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        b90 = new JButton();
        b90.setEnabled(true);
        Font b90Font = this.$$$getFont$$$(null, -1, -1, b90.getFont());
        if (b90Font != null) b90.setFont(b90Font);
        b90.setHideActionText(false);
        b90.setHorizontalTextPosition(0);
        b90.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b90.setText("");
        fila9.add(b90, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b91 = new JButton();
        b91.setEnabled(true);
        Font b91Font = this.$$$getFont$$$(null, -1, -1, b91.getFont());
        if (b91Font != null) b91.setFont(b91Font);
        b91.setHideActionText(false);
        b91.setHorizontalTextPosition(0);
        b91.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b91.setText("");
        fila9.add(b91, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b92 = new JButton();
        b92.setEnabled(true);
        Font b92Font = this.$$$getFont$$$(null, -1, -1, b92.getFont());
        if (b92Font != null) b92.setFont(b92Font);
        b92.setHideActionText(false);
        b92.setHorizontalTextPosition(0);
        b92.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b92.setText("");
        fila9.add(b92, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        b93.setEnabled(true);
        Font b93Font = this.$$$getFont$$$(null, -1, -1, b93.getFont());
        if (b93Font != null) b93.setFont(b93Font);
        b93.setHideActionText(false);
        b93.setHorizontalTextPosition(0);
        b93.setIcon(new ImageIcon(getClass().getResource("/images/empty.png")));
        b93.setText("");
        fila9.add(b93, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(0, 0), new Dimension(40, 40), new Dimension(40, 40), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        playerPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }
}
