package chappie.test;

import chappie.test.client.ClientEventHandler;
import chappie.test.common.CommonEventHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;

@Mod(TestMod.MODID)
public class TestMod
{
    public static void LOGGER(String logThis) {
        LogManager.getLogger().info("Test: "+logThis);
    }
    public static final String MODID = "test";

    public TestMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.register(this);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(this::doClientStuff);
            MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        });

    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}
