package us.donut.visualbukkit.blocks.expressions;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.ModificationType;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.annotations.Modifier;
import us.donut.visualbukkit.blocks.syntax.Syntax;

import java.util.List;

@Description({"The players viewing a boss bar", "Returns: list of players"})
@Modifier({ModificationType.ADD, ModificationType.REMOVE, ModificationType.CLEAR})
public class ExprBossBarPlayers extends ExpressionBlock<List> {

    @Override
    protected Syntax init() {
        return new Syntax("players of", BossBar.class);
    }

    @Override
    public String toJava() {
        return "PluginMain.createList(" + arg(0) + ".getPlayers())";
    }

    @Override
    public String modify(ModificationType modificationType, String delta) {
        switch (modificationType) {
            case CLEAR: return arg(0) + ".removeAll();";
            case ADD: return arg(0) + ".addPlayer(" + delta + ");";
            case REMOVE: return arg(0) + ".removePlayer(" + delta + ");";
            default: return null;
        }
    }

    @Override
    public Class<?> getDeltaType(ModificationType modificationType) {
        return Player.class;
    }
}
