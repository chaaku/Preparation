import java.util.Stack;

/**
 * 12/23/2014
 * 
 * @author tusroy
 * 
 *         Video link https://youtu.be/ZmnqCZp9bBs
 * 
 *         Given an array representing height of bar in bar graph, find max
 *         histogram area in the bar graph. Max histogram will be max
 *         rectangular area in the graph.
 * 
 *         Maintain a stack
 * 
 *         If stack is empty or value at index of stack is less than or equal to
 *         value at current index, push this into stack. Otherwise keep removing
 *         values from stack till value at index at top of stack is less than
 *         value at current index. While removing value from stack calculate
 *         area if stack is empty it means that till this point value just
 *         removed has to be smallest element so area = input[top] * i if stack
 *         is not empty then this value at index top is less than or equal to
 *         everything from stack top + 1 till i. So area will area = input[top]
 *         * (i - stack.peek() - 1); Finally maxArea is area if area is greater
 *         than maxArea.
 * 
 * 
 *         Time complexity is O(n) Space complexity is O(n)
 * 
 *         References:
 *         http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */

// best explanation :
// https://tech.pic-collage.com/algorithm-largest-area-in-histogram-84cc70500f0c
public class MaximumHistogram {

	public static int largestRectanglularAreaInHistogram(int[] arr) {
		int maxArea = 0;

		// Iterate through the histogram.
		for (int i = 0; i < arr.length; ++i) {
			int h = arr[i];

			maxArea = Math.max(maxArea, h);

			for (int j = i; j >= 0; j--) {

				final int w = (i - j + 1);
				h = Math.min(h, arr[j]);
				maxArea = Math.max(maxArea, h * w);
			}
		}

		return maxArea;
	}

	static int getMaxArea(int arr[], int n) {
		// Create an empty stack. The stack holds indexes of hist[] array
		// The bars stored in stack are always in increasing order of their
		// heights.
		Stack<Integer> s = new Stack<>();

		int max_area = 0; // Initialize max area
		int tp; // To store top of stack
		int area_with_top; // To store area with top bar as the smallest bar

		// Run through all bars of given histogram
		int i = 0;
		while (i < n) {
			// If this bar is higher than the bar on top stack, push it to stack
			if (s.empty() || arr[s.peek()] <= arr[i])
				s.push(i++);

			// If this bar is lower than top of stack, then calculate area of rectangle
			// with stack top as the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before top in stack is 'left index'
			else {
				tp = s.peek(); // store the top index
				s.pop(); // pop the top

				// Calculate the area with hist[tp] stack as smallest bar
				area_with_top = arr[tp] * (s.empty() ? i : i - s.peek() - 1);

				// update max area, if needed
				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			area_with_top = arr[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;

	}

	public static void main(String args[]) {
		MaximumHistogram mh = new MaximumHistogram();
		int input[] = { 2, 2, 2, 6, 1, 5, 6, 2, 8, 2, 2, 2 };
		int maxArea = getMaxArea(input, input.length);
		System.out.println(maxArea);

		System.out.println("naive approach :" + largestRectanglularAreaInHistogram(input));
		assert maxArea == 12;
	}
}