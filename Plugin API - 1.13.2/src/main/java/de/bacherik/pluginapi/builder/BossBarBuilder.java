package de.bacherik.pluginapi.builder;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarBuilder {

    private final BossBar bossBar;

    public BossBarBuilder(String title) {
        bossBar = Bukkit.createBossBar(title, BarColor.PURPLE, BarStyle.SOLID);
        bossBar.setProgress(0);
    }

    public BossBarBuilder setTitle(String title) {
        bossBar.setTitle(title);
        return this;
    }

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

    public BossBarBuilder setProgress(double progress) {
        return setProgress(0, 100, progress);
    }

    public BossBarBuilder setColor(BarColor barColor) {
        bossBar.setColor(barColor);
        return this;
    }

    public BossBarBuilder setStyle(BarStyle barStyle) {
        bossBar.setStyle(barStyle);
        return this;
    }

    public BossBarBuilder addFlag(BarFlag barFlag) {
        bossBar.addFlag(barFlag);
        return this;
    }

    public BossBarBuilder add(Player player) {
        bossBar.addPlayer(player);
        return this;
    }

    public BossBarBuilder remove(Player player) {
        bossBar.removePlayer(player);
        return this;
    }
}