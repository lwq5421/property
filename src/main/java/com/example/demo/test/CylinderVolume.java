package com.example.demo.test;

import java.util.Scanner;

public class CylinderVolume {
    public static void main(String[] args) {
        // 创建 Scanner 对象来读取用户输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入底面半径和高
        System.out.print("请输入底面半径（输入0退出）: ");
        double radius = scanner.nextDouble();
        System.out.print("请输入圆柱的高（输入0退出）: ");
        double height = scanner.nextDouble();

        // 循环计算圆柱的体积，直到用户输入0
        while (radius != 0 || height != 0) {
            // 判断半径和高是否小于等于0
            if (radius <= 0 || height <= 0) {
                System.out.println("底面半径和高必须大于0，请重新输入！");
            } else {
                // 计算圆柱的体积
                double volume = Math.PI * Math.pow(radius, 2) * height;

                // 输出结果
                System.out.println("底面半径是: " + radius);
                System.out.println("圆柱的高是: " + height);
                System.out.println("圆柱的体积是: " + volume);
            }

            // 提示用户输入下一个底面半径和高
            System.out.print("请输入底面半径（输入0退出）: ");
            radius = scanner.nextDouble();
            System.out.print("请输入圆柱的高（输入0退出）: ");
            height = scanner.nextDouble();
        }

        // 关闭 Scanner 对象
        scanner.close();
    }
}
