package prefixSum;
public class SpecialIndex {
    public static int specialIndex(int[] arr)
    {
        int N = arr.length;
        int[] PFe = new int[N];
        int[] PFo = new int[N];
        PFo[0] = 0;
        PFe[0] = arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            if(i%2!=0)
            {
                PFo[i] = PFo[i-1] + arr[i];
                PFe[i] = PFe[i-1];
            }
            else
            {
                PFe[i] = PFe[i-1] + arr[i];
                PFo[i] = PFo[i-1];
            }
        }
        int count = 0;
        int Se;
        int So;
        Se = PFo[N-1] -PFo[0];
        So = PFe[N-1] - PFe[0];
        if(Se == So)
        {
            count++;
        }
        for(int i=1;i<N;i++)
        {
            Se = PFe[i-1] + PFo[N-1]-PFo[i];
            So = PFo[i-1] + PFe[N-1]-PFe[i];
            
            if(Se == So)
            {
                count++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		int[] arr = {4,3,2,7,6,-2};
		int res =specialIndex(arr);
		System.out.println(res);
	}
}
