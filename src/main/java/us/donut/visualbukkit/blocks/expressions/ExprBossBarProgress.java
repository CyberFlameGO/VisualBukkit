package us.donut.visualbukkit.blocks.expressions;

import org.bukkit.boss.BossBar;
import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.ModificationType;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.annotations.Modifier;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description({"The progress of a boss bar", "Returns: number"})
@Modifier({ModificationType.SET, ModificationType.ADD, ModificationType.REMOVE})
public class ExprBossBarProgress extends ExpressionBlock<Double> {

    @Override
    protected Syntax init() {
        return new Syntax("progress of", BossBar.class);
    }

    @Override
    public String toJava() {
        return arg(0) + ".getProgress()";
    }

    @Override
    public String modify(ModificationType modificationType, String delta) {
        switch (modificationType) {
            case SET: return arg(0) + ".setProgress(" + delta + ");";
            case ADD: return modify(ModificationType.SET, toJava() + "+" + delta);
            case REMOVE: return modify(ModificationType.SET, toJava() + "-" + delta);
            default: return null;
        }
    }
}
