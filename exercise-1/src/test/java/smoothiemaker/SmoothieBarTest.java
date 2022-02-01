package smoothiemaker;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SmoothieBarTest {
    @Test
    public void canBlendOrangesAndAppleSmoothie() {
    	SmoothieBar smoothieBar = new SmoothieBar();
    	smoothieBar.restockApples(2);
    	smoothieBar.restockOranges(2);
    	Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
    	assertTrue(smoothie.getKind() == SmoothieKind.OrangeAndAppleSmoothie);
    }
    
    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangesAndApples() {
    	SmoothieBar smoothieBar = new SmoothieBar();
    	smoothieBar.restockApples(2);
    	smoothieBar.restockOranges(2);
    	Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);
    	assertTrue(smoothieBar.getApplesInStock() == 0);
    	assertTrue(smoothieBar.getOrangesInStock() == 0);
    }
    
    @Test
    public void blendingBananasAndAppleSmoothieConsumesBananasAndApples() {
    	SmoothieBar smoothieBar = new SmoothieBar();
    	smoothieBar.restockApples(2);
    	smoothieBar.restockBananas(2);
    	Smoothie smoothie = smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothe);
    	assertTrue(smoothieBar.getApplesInStock() == 0);
    	assertTrue(smoothieBar.getBananasInStock() == 1);
    }
    
    @Test
    public void illigalBlendSize() {
    	SmoothieBar smoothieBar = new SmoothieBar();
    	//smoothieBar.restockApples(0);
    	//smoothieBar.restockBananas(0);
    	assertThrows(IllegalStateException.class, () -> smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothe));
    }
}