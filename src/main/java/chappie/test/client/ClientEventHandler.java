package chappie.test.client;

import chappie.test.TestMod;
import chappie.test.client.screen.TestScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class ClientEventHandler {

    private static final String CATEGORY = "key.categories." + TestMod.MODID;

    public static final KeyBinding SCREEN = new KeyBinding(TestMod.MODID + ".key.screen", GLFW.GLFW_KEY_G, CATEGORY);

    public ClientEventHandler() {
        ClientRegistry.registerKeyBinding(SCREEN);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        PlayerEntity player = Minecraft.getInstance().player;
        if (this.SCREEN.isPressed()) {
            player.world.playSound(player, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.NEUTRAL, 1, 0);
            Minecraft.getInstance().displayGuiScreen(new TestScreen());
        }
    }
}
