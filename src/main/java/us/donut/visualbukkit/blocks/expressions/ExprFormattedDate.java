package us.donut.visualbukkit.blocks.expressions;

import us.donut.visualbukkit.blocks.ExpressionBlock;
import us.donut.visualbukkit.blocks.annotations.Description;
import us.donut.visualbukkit.blocks.syntax.Syntax;

import java.time.LocalDateTime;

@Description({"A formatted date", "Returns: string"})
public class ExprFormattedDate extends ExpressionBlock<String> {

    @Override
    protected Syntax init() {
        return new Syntax(LocalDateTime.class, "with format", String.class);
    }

    @Override
    public String toJava() {
        return "java.time.format.DateTimeFormatter.ofPattern(" + arg(1) + ").format(" + arg(0) + ")";
    }
}
