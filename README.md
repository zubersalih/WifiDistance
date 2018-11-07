# WifiDistance
- is an android app that let's you calculate the distance between your phone and the wifi router
- it uses **```Free-space path loss(FSPL)```** formula to calculate the distance.
- FSPL depends on two parameters: First is the frequency of radio signals；Second is the wireless transmission distance. The following formula can reflect the relationship between them.

```
FSPL (dB) = 20log10(d) + 20log10(f) + K

d = distance
f = frequency
K= constant that depends on the units used for d and f
If d is measured in kilometers, f in MHz, the formula is:

FSPL (dB) = 20log10(d)+ 20log10(f) + 32.44
```

From the Fade Margin equation, Free Space Path Loss can be computed with the following equation.

```
Free Space Path Loss=Tx Power-Tx Cable Loss+Tx Antenna Gain+Rx Antenna Gain - Rx Cable Loss - Rx Sensitivity - Fade Margin
```

With the above two Free Space Path Loss equations, we can find out the Distance in km.

```
Distance (km) = 10(Free Space Path Loss – 32.44 – 20log10(f))/20
```

The Fresnel Zone is the area around the visual line-of-sight that radio waves spread out into after they leave the antenna. You want a clear line of sight to maintain strength, especially for 2.4GHz wireless systems. This is because 2.4GHz waves are absorbed by water, like the water found in trees. The rule of thumb is that 60% of Fresnel Zone must be clear of obstacles. Typically, 20% Fresnel Zone blockage introduces little signal loss to the link. Beyond 40% blockage the signal loss will become significant.

```
FSPLr=17.32*√(d/4f)

d = distance [km]
f = frequency [GHz]
r = radius [m]
```
[The Source from TP-LINK](https://web.archive.org/web/20120221030519/http://www.tp-link.com.au/support/calculator/)
# Screenshot

![Screenshot](wifidistancescreenshot.jpg?raw=true "Screenshot")
