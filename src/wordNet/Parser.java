/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordNet;

import java.util.Map;

/**
 *
 * @author artur
 */
public interface Parser {
    public void parse(String s, Map<String, Object> map);
}
