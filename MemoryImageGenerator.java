/*
* <applet code="MemoryImageGenerator" width=256 height=256>
* </applet>
*/
import java.applet.*;
import java.awt.*;
import java.awt.image.*;
public class MemoryImageGenerator extends Applet {
Image img;
public void init() {
Dimension d = getSize();
int w = d.width;
int h = d.height;
int pixels[] = new int[w * h];
int i = 0;
for(int y=0; y<h; y++) {
for(int x=0; x<w; x++) {
int r = (x^y)&0xff;
int g = (x*2^y*2)&0xff;
int b = (x*4^y*4)&0xff;
pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
}
}
img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
}
public void paint(Graphics g) {
g.drawImage(img, 0, 0, this);
}
}
/*
The data for the new MemoryImageSource is created in the init( ) method. An array
of integers is created to hold the pixel values; the data is generated in the nested for loops
where the r, g, and b values get shifted into a pixel in the pixels array. Finally, createImage( )
is called with a new instance of a MemoryImageSource created from the raw pixel data as
its parameter. Figure 26-4 shows the image when we run the applet. (It looks much nicer in
color.)*/
