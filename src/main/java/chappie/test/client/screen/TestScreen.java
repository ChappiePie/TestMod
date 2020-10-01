package chappie.test.client.screen;

import chappie.test.TestMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextProperties;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;

public class TestScreen extends Screen {

    private final int xSize = 256;
    private final int ySize = 256;
    private int left;
    private int top;

    public TestScreen() {
        super(new TranslationTextComponent("gui.test.test"));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    protected void init() {
        super.init();
        left = (width - xSize) / 2;
        top = (height - ySize) / 2;
    }

    @Override
    public void render(MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
        matrix.push();
        //With Render System u can make it bigger

        //Its string for font
        String s = "Hi bro";

        //Render String
        this.font.func_238418_a_(getComicSansName(this.font, s), left + 50, top + 50,86 - this.font.getStringWidth(s), 0xfefefe);
        matrix.pop();
    }

    private static final ResourceLocation COMIC_SANS_FONT = new ResourceLocation(TestMod.MODID, "default");
    private static final Style COMIC_SANS_STYLE = Style.EMPTY.setFontId(COMIC_SANS_FONT);

    public ITextProperties getComicSansName(FontRenderer fontRenderer, String string) {
        int maxWidth = 86 - this.font.getStringWidth(string);
        return fontRenderer.getCharacterManager().func_238358_a_((new StringTextComponent(string)).mergeStyle(COMIC_SANS_STYLE), maxWidth, Style.EMPTY);
    }
}
