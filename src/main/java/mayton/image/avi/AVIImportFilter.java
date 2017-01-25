/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mayton.image.avi;

/**
 *
 * AVI Header Format

AVI files contain a 56-byte header, starting at offset 32 within the file.

offset size	description

0	4	time delay between frames in microseconds
4	4	data rate of AVI data
8	4	padding multiple size, typically 2048
12	4	parameter flags
16	4	number of video frames
20      4	number of preview frames
24	4	number of data streams (1 or 2)
28      4	suggested playback buffer size in bytes
32      4	width of video image in pixels
36	4	height of video image in pixels
40	4	time scale, typically 30
44	4	data rate (frame rate = data rate / time scale)
48      4	starting time, typically 0
52      4	size of AVI data chunk in time scale units
 * @author mayton
 */
public class AVIImportFilter {
    
}
