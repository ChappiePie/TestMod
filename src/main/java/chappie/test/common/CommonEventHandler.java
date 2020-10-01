package chappie.test.common;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonEventHandler {
    /* Its for size sha
    @SubscribeEvent
    public void PlayerSizeEvent(EntityEvent.Size e) {
        if(e.getEntity() instanceof PlayerEntity) {
            EntitySize size = e.getOldSize();
            e.setNewSize(EntitySize.fixed(size.width * 2f, size.height * 2f));
            e.setNewEyeHeight(e.getOldEyeHeight() * 2f);
        }
    }
     */
}
