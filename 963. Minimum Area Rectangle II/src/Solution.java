public class Solution {

    private static boolean compareDouble(double a, double b){
        double EPSILON = 1e-3;
        return Math.abs(a - b) < EPSILON;
    }

    public double minAreaFreeRect1(int[][] points) {
        double minArea = 0;
        for(int i = 0; i < points.length - 3; i++){
            for(int j = i + 1; j < points.length - 2; j++){
                for(int k = j + 1; k < points.length - 1; k++){
                    for(int l = k + 1; l < points.length; l++){

                        double cx = (double) (points[i][0] + points[j][0] + points[k][0] + points[l][0]) / 4;
                        double cy = (double) (points[i][1] + points[j][1] + points[k][1] + points[l][1]) / 4;

                        double dd1 = (cx - points[i][0]) * (cx - points[i][0]) + (cy - points[i][1]) * (cy - points[i][1]);
                        double dd2 = (cx - points[j][0]) * (cx - points[j][0]) + (cy - points[j][1]) * (cy - points[j][1]);
                        double dd3 = (cx - points[k][0]) * (cx - points[k][0]) + (cy - points[k][1]) * (cy - points[k][1]);
                        double dd4 = (cx - points[l][0]) * (cx - points[l][0]) + (cy - points[l][1]) * (cy - points[l][1]);

                        if(compareDouble(dd1, dd2) && compareDouble(dd1, dd3) && compareDouble(dd1, dd4)){
                            double s1 = Math.sqrt((points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]));
                            double s2 = Math.sqrt((points[i][0] - points[k][0]) * (points[i][0] - points[k][0]) + (points[i][1] - points[k][1]) * (points[i][1] - points[k][1]));
                            double s3 = Math.sqrt((points[i][0] - points[l][0]) * (points[i][0] - points[l][0]) + (points[i][1] - points[l][1]) * (points[i][1] - points[l][1]));

                            double area = 0;

                            if(Double.valueOf(s1).isNaN()){
                                area = s2*s3;
                            } else if(Double.valueOf(s2).isNaN()){
                                area = s1*s3;
                            } else if (Double.valueOf(s3).isNaN()) {
                                area = s2*s1;
                            } else{
                                area = (s1 * s2 * s3) / Math.max(s1, Math.max(s2, s3));
                            }
                            if(area < minArea || compareDouble(minArea, 0)){
                                minArea = area;
                            }
                        }
                    }
                }
            }
        }
        return minArea;
    }

}
