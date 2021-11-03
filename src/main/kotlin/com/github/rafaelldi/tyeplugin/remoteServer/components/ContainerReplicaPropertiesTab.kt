package com.github.rafaelldi.tyeplugin.remoteServer.components

import com.github.rafaelldi.tyeplugin.model.TyeContainerServiceReplica
import com.intellij.ui.components.JBScrollPane
import javax.swing.JComponent
import javax.swing.table.DefaultTableModel

class ContainerReplicaPropertiesTab(replica: TyeContainerServiceReplica) : PropertiesTab() {
    companion object {
        private const val NAME_COLUMN_TITLE = "Name"
        private const val VALUE_COLUMN_TITLE = "Value"
    }

    override val component: JComponent

    init {
        val table = DefaultTableModel(arrayOf(NAME_COLUMN_TITLE, VALUE_COLUMN_TITLE), 0)

        with(table) {
            addRow(arrayOf("Name", replica.name))
            addRow(arrayOf("Docker command", replica.dockerCommand))
            addRow(arrayOf("Container id", replica.containerId))
            addRow(arrayOf("Docker network", replica.dockerNetwork))
            addRow(arrayOf("Docker network alias", replica.dockerNetworkAlias))
        }

        component = JBScrollPane(ValueTable(table))
    }
}