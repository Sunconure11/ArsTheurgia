package team.comofas.arstheurgia.items;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import team.comofas.arstheurgia.ArsTheurgia;
import team.comofas.arstheurgia.gui.GuiUtils;
import team.comofas.arstheurgia.player.PlayerComponents;

public class OpenableTablet extends Item {

    public String ritualName;

    public OpenableTablet(Settings settings, String ritualName) {
        super(settings);
        this.ritualName = ritualName;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) {
            GuiUtils.openTabletScreen(itemStack);
        } else {
            System.out.println("oi "+itemStack.getItem().getName().getString());
            if (itemStack.getItem().getName().getString().startsWith("item.arstheurgia.cooked_clay_tablet_")) {
                System.out.println("this is "+PlayerComponents.KNOWLEDGE.get(user).hasKnowledge(this.ritualName));
                PlayerComponents.KNOWLEDGE.get(user).setKnowledge(this.ritualName, true);
                user.sendMessage(new LiteralText("já sabes"), false);
            }
        }

        return TypedActionResult.method_29237(itemStack, world.isClient());

    }
}

