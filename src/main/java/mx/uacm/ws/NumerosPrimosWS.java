/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.ws;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Profesor
 */
@WebService(serviceName = "NumerosPrimosWS")
public class NumerosPrimosWS {

    public List<Integer> numerosPrimos(int n) {
        boolean primo[] = new boolean[n + 1];
        Arrays.fill(primo, true);
        for (int p = 2; p * p <= n; p++) {
            if (primo[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    primo[i] = false;
                }
            }
        }
        List<Integer> numerosPrimos = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (primo[i]) {
                numerosPrimos.add(i);
            }
        }
        return numerosPrimos;
    }

}
