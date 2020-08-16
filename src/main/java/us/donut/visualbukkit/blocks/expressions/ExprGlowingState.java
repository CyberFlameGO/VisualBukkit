package us.donut.visualbukkit.blocks.expressions;

import org.bukkit.entity.Entity;
import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.ModificationType;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.annotations.Modifier;
import us.donut.visualbukkit.blocks.syntax.Syntax;

@Description({"The glowing state of an entity", "Returns: boolean"})
@Modifier(ModificationType.SET)
public class ExprGlowingState extends ExpressionBlock<Boolean> {

    @Override
    protected Syntax init() {
        return new Syntax("glowing state of", Entity.class);
    }

    @Override
    public String toJava() {
        return arg(0) + ".isGlowing()";
    }

    @Override
    public String modify(ModificationType modificationType, String delta) {
        return modificationType == ModificationType.SET ? arg(0) + ".setGlowing(" + delta + ");" : null;
    }
}
