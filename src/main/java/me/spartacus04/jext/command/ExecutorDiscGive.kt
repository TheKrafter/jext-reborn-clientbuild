package me.spartacus04.jext.command

import me.spartacus04.jext.config.ConfigData
import me.spartacus04.jext.config.ConfigData.Companion.DISCS
import me.spartacus04.jext.disc.DiscContainer
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

internal class ExecutorDiscGive : ExecutorAdapter("discgive") {
    init {
        addParameter(ParameterPlayer(true))
        addParameter(ParameterDisc(true))
    }

    override fun executePlayer(sender: Player, args: Array<String>): Boolean {
        return mergedExecute(sender, args)
    }

    override fun executeCommand(sender: CommandSender, args: Array<String>): Boolean {
        return mergedExecute(sender, args)
    }

    private fun mergedExecute(sender: CommandSender, args: Array<String>): Boolean {
        val players = PlayerSelector(sender, args[0]).players ?: return true

        val disc = DISCS.find { it.DISC_NAMESPACE == args[0] }

        if (disc == null) {
            sender.sendMessage(
                "[§aJEXT§f]  ${ConfigData.LANG.DISC_NAMESPACE_NOT_FOUND}"
                    .replace("%namespace%", args[0])
            )
            return true
        }

        for (player in players) {
            player!!.inventory.addItem(DiscContainer(disc).discItem)

            player.sendMessage(
                "[§aJEXT§f]  ${ConfigData.LANG.DISC_RECEIVED}"
                    .replace("%disc%", disc.TITLE)
            )
        }

        val playerCount = players.size

        if (playerCount >= 2) {
            sender.sendMessage(
                "[§aJEXT§f]  ${ConfigData.LANG.DISC_GIVEN_MULTIPLE}"
                    .replace("%disc%", disc.TITLE)
                    .replace("%playercount%", playerCount.toString())
            )
        } else if (playerCount == 1) {
            sender.sendMessage(
                "[§aJEXT§f]  ${ConfigData.LANG.DISC_GIVEN}"
                    .replace("%disc%", disc.TITLE)
                    .replace("%playername%", players[0]!!.name)
            )
        } else {
            sender.sendMessage(
                "[§aJEXT§f]  ${ConfigData.LANG.NO_DISC_GIVEN}"
            )
        }
        return true
    }
}