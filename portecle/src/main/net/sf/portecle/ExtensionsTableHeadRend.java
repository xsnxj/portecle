/*
 * ExtensionsTableHeadRend.java
 * This file is part of Portecle, a multipurpose keystore and certificate tool.
 *
 * Copyright © 2004 Wayne Grant, waynedgrant@hotmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package net.sf.portecle;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * Custom cell renderer for the headers of the Extensions table of
 * DViewExtensions.
 */
class ExtensionsTableHeadRend extends DefaultTableCellRenderer
{
    /** Resource bundle */
    private static ResourceBundle m_res =
        ResourceBundle.getBundle("net/sf/portecle/resources");

    /**
     * Returns the rendered header cell for the supplied value and column.
     *
     * @param jtExtensions The JTable
     * @param value The value to assign to the cell
     * @param bIsSelected True if cell is selected
     * @param iRow The row of the cell to render
     * @param iCol The column of the cell to render
     * @param bHasFocus If true, render cell appropriately
     * @return The renderered cell
     */
    public Component getTableCellRendererComponent(JTable jtExtensions,
                                                   Object value,
                                                   boolean bIsSelected,
                                                   boolean bHasFocus,
                                                   int iRow, int iCol)
    {
        // Get header renderer
        JLabel header = (JLabel)
            jtExtensions.getColumnModel().getColumn(iCol).getHeaderRenderer();

        // The Crtical header contains an icon
        if (iCol == 0)
        {
            header.setText("");
            ImageIcon icon = new ImageIcon(
                getClass().getResource(
                    m_res.getString(
                        "ExtensionsTableHeadRend.CriticalColumn.image")));
            header.setIcon(icon);
            header.setHorizontalAlignment(CENTER);
            header.setVerticalAlignment(CENTER);

            header.setToolTipText(
                m_res.getString(
                    "ExtensionsTableHeadRend.CriticalColumn.tooltip"));
        }
        // The other headers contain text
        else
        {
            header.setText(value.toString());
            header.setHorizontalAlignment(LEFT);

            // Set tool tips
            if (iCol == 1)
            {
                header.setToolTipText(
                    m_res.getString(
                        "ExtensionsTableHeadRend.NameColumn.tooltip"));
            }
            else
            {
                header.setToolTipText(
                    m_res.getString(
                        "ExtensionsTableHeadRend.OidColumn.tooltip"));
            }
        }

        header.setBorder(new CompoundBorder(
                             new BevelBorder(BevelBorder.RAISED),
                             new EmptyBorder(0, 5, 0, 5)));

        return header;
    }
}
