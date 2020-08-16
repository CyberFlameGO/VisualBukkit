package us.donut.visualbukkit.blocks.expressions;

import org.bukkit.entity.Entity;
import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.ModificationType;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.annotations.Modifier;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description({"The max fire ticks of an entity", "Returns: number"})
@Modifier({ModificationType.SET, ModificationType.ADD, ModificationType.REMOVE})
public class ExprMaxFireTicks extends ExpressionBlock<Integer> {

    @Override
    protected Syntax init() {
        return new Syntax("max fire ticks of", Entity.class);
    }

    @Override
    public String toJava() {
        return arg(0) + ".getMaxFireTicks()";
    }

    @Override
    public String modify(ModificationType modificationType, String delta) {
        switch (modificationType) {
            case SET: return arg(0) + ".setMaxFireTicks(" + delta + ");";
            case ADD: return modify(ModificationType.SET, toJava() + "+" + delta);
            case REMOVE: return modify(ModificationType.SET, toJava() + "-" + delta);
            default: return null;
        }
    }
}
