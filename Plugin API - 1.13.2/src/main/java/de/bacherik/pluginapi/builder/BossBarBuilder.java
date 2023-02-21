package de.bacherik.pluginapi.builder;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

/**
 * This class is used to make create Boss bar's easier.
 * @author Let's play Nik
 */
public class BossBarBuilder {

    private final BossBar bossBar;

    /**
     * This is the constructor for the Boss bar with all necessary parameters
     * @param title This is the Title of the Boss bar
     */
    public BossBarBuilder(String title) {
        bossBar = Bukkit.createBossBar(title, BarColor.PURPLE, BarStyle.SOLID);
        bossBar.setProgress(0);
    }

    /**
     * This is to change the title
     * @param title set the Title of the Boss bar
     */
    public BossBarBuilder setTitle(String title) {
        bossBar.setTitle(title);
        return this;
    }

    /**
     * This is used when a number between 1 and 100 has not yet been generated to indicate the progress around the boss bar.
     * @param min the minimum number of the Boss bar (0%)
     * @param max the maximum number of the Boss bar (100%)
     * @param value the actual number between min and max
     */
    public BossBarBuilder setProgress(double min, double max, double value) {
        if (value >= min && value <= max) {
            double end0 = max - min;
            double value0 = value - min;
            bossBar.setProgress(value0 / end0);
            return this;
        } else {
            throw new IllegalArgumentException("The value must between " + min + " and " + max);
        }
    }

    /**
     * The simpler version of the other setProgress.
     * @param progress the value between 0 and 100
     */
    public BossBarBuilder setProgress(double progress) {
        return setProgress(0, 100, progress);
    }

    /**
     * To change the color of the Boss bar
     * @param barColor the color af the Boss bar
     */
    public BossBarBuilder setColor(BarColor barColor) {
        bossBar.setColor(barColor);
        return this;
    }

    /**
     * This is the style used for the Boss bar, for example how many segments there are.
     * @param barStyle enum of BarStyle
     */
    public BossBarBuilder setStyle(BarStyle barStyle) {
        bossBar.setStyle(barStyle);
        return this;
    }

    /**
     * I don`t know I have never used it, but it comes from the BarFlag enum which is also used, but I don`t know what effect it has.
     * @param barFlag enum BarFlag
     */

    public BossBarBuilder addFlag(BarFlag barFlag) {
        bossBar.addFlag(barFlag);
        return this;
    }

    /**
     * Adds a player to a list of which players see the boss bar.
     * @param player The player who should see the boss bar.
     */
    public BossBarBuilder add(Player player) {
        bossBar.addPlayer(player);
        return this;
    }

    /**
     * Removes a player to a list of which players see the boss bar.
     * @param player The player who shouldn't see the boss bar.
     */
    public BossBarBuilder remove(Player player) {
        bossBar.removePlayer(player);
        return this;
    }
}