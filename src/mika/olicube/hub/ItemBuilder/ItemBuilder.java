package mika.olicube.hub.ItemBuilder;

import java.util.Arrays;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
    private ItemStack is;

    public ItemBuilder(Material m) {
        this(m, 1);
    }

    public ItemBuilder(ItemStack is) {
        this.is = is;
    }

    public ItemBuilder(Material m, int amount) {
        this.is = new ItemStack(m, amount);
    }

    public ItemBuilder(Material m, int amount, short meta) {
        this.is = new ItemStack(m, amount, meta);
    }

    public ItemBuilder clone() throws CloneNotSupportedException {
        ItemBuilder clone = (ItemBuilder)super.clone();
        return new ItemBuilder(this.is);
    }

    public ItemBuilder setDurability(short dur) {
        this.is.setDurability(dur);
        return this;
    }

    public ItemBuilder setName(String name) {
        ItemMeta im = this.is.getItemMeta();
        im.setDisplayName(name);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder addUnsafeEnchantment(Enchantment ench, int level, ItemFlag hideEnchants) {
        this.is.addUnsafeEnchantment(ench, level);
        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment ench) {
        this.is.removeEnchantment(ench);
        return this;
    }

    public ItemBuilder setSkullOwner(String owner) {
        try {
            SkullMeta im = (SkullMeta)this.is.getItemMeta();
            im.setOwner(owner);
            this.is.setItemMeta(im);
        } catch (ClassCastException var3) {
        }

        return this;
    }

    public ItemBuilder addEnchant(Enchantment ench, int level, ItemFlag hideEnchants) {
        ItemMeta im = this.is.getItemMeta();
        im.addEnchant(ench, level, true);
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setInfinityDurability() {
        this.is.setDurability((short)32767);
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        ItemMeta im = this.is.getItemMeta();
        im.setLore(Arrays.asList(lore));
        this.is.setItemMeta(im);
        return this;
    }

    public ItemBuilder setLeatherArmorColor(Color color) {
        try {
            LeatherArmorMeta im = (LeatherArmorMeta)this.is.getItemMeta();
            im.setColor(color);
            this.is.setItemMeta(im);
        } catch (ClassCastException var3) {
        }

        return this;
    }

    public ItemStack toItemStack() {
        return this.is;
    }
}
