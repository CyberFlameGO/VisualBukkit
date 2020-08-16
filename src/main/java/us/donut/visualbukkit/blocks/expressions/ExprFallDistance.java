package us.donut.visualbukkit.blocks.expressions;

import org.bukkit.entity.Entity;
import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.ModificationType;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.annotations.Modifier;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description({"The distance an entity has fallen", "Returns: number"})
@Modifier({ModificationType.SET, ModificationType.ADD, ModificationType.REMOVE})
public class ExprFallDistance extends ExpressionBlock<Float> {

    @Override
    protected Syntax init() {
        return new Syntax("fall distance of", Entity.class);
    }

    @Override
    public String toJava() {
        return arg(0) + ".getFallDistance()";
    }

    @Override
    public String modify(ModificationType modificationType, String delta) {
        switch (modificationType) {
            case SET: return arg(0) + ".setFallDistance(" + delta + ");";
            case ADD: return modify(ModificationType.SET, toJava() + "+" + delta);
            case REMOVE: return modify(ModificationType.SET, toJava() + "-" + delta);
            default: return null;
        }
    }
}
