package program;
public class Render {
    public void viewBar(Object object) {
        double current;
        double max;

        if (object instanceof HaveHealthPoints haveHealthPoints) {
            max = haveHealthPoints.getMaxHealthPoints();
            current = haveHealthPoints.getCurrentHealthPoints();
            printThreeColoredBar(getBarProgress(current, max), max);
        }

    }

    private void printThreeColoredBar(double bar, double maxPoints) {
        String collor = "\u001B[32m";

        if (bar < 4) {
            collor = "\u001B[31m";
        } else if (bar < 8) {
            collor = "\u001B[33m";
        }

        printOneColoredBar(bar, maxPoints, collor);
    }

    private void printOneColoredBar(double bar, double maxPoints, String collor) {
        System.out.print(collor);

        for (int i = 0; i < bar; i++) {
            System.out.print("█");
        }

        for (int i = 0; i < 10 - bar; i++) {
            System.out.print("_");
        }

        System.out.println(" " + "\u001B[0m");
    }

    private double getBarProgress(double current, double max) {
        double bar = current * 10 / max;

        if (current > 0 && bar == 0) {
            return 1;
        }
        return bar;
    }
}