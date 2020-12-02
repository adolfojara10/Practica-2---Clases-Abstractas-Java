/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ups.edu.ec.modelo.Actividad;

/**
 *
 * @author User
 */
public class ControladorActividad extends Controlador {

    private Pattern patron;
    private Matcher corpus;

    public ControladorActividad(String ruta) {
        super(ruta);
        //this.patron = Pattern.compile("^<a\\shref=\"\\/store\\/apps\\/details?id=com(\\.(\\w)+)+\"><div\\sclass=\"(\\w+\\s\\w+)\"\\stitle=\"(\\w(\\s)?)+\"$");

        //this.patron = Pattern.compile("<a\\shref=\\\"\\/store\\/apps\\/details\\?id=com(\\.(\\w+))+\\\"(\\s)?><div\\sclass=\\\"((\\w+)\\s(\\w+))\\\"\\stitle=\\\"(\\w+)(\\s\\w)*\\\">");
        //this.patron = Pattern.compile("<a\\shref=\\\"\\/store\\/apps\\/details\\?id=com(\\.(\\w+))+\\\"(\\s)?><div\\sclass=\\\"((\\w+)\\s(\\w+))\\\"\\stitle=\\\"(\\w+)((\\s\\w+)*)?\\\">");
        //this.patron = Pattern.compile("<a\\shref=\\\"\\/store\\/apps\\/details\\?id=(\\w+)(\\.(\\w+))+\\\"(\\s)?><div\\sclass=\\\"((\\w+)\\s(\\w+))\\\"\\stitle=\\\".*\\\">");
        this.patron = Pattern.compile("<a\\shref=\\\"\\/store\\/apps\\/details\\?id=(\\w+)(\\.(\\w+))+\\\"(\\s)?><div\\sclass=\\\"((\\w+)\\s(\\w+))\\\"\\stitle=\\\"(\\w+|([.,\\/#!$%\\^&\\*;:=-_\\s])*)*\\\">");
    }

    public Actividad buscarActividad(String texto) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL urlObject = new URL("https://play.google.com/store/search?q=" + (texto.replaceAll("\\s", "\\20%")) + "&c=apps");
            URLConnection conection = urlObject.openConnection();

            conection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            BufferedReader buffer = new BufferedReader(new InputStreamReader(conection.getInputStream(), "UTF-8"));

            String inputLine;

            while ((inputLine = buffer.readLine()) != null) {

                if (inputLine.contains(patron.pattern())) {

                    stringBuilder.append(inputLine);
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(inputLine);
                }

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ControladorActividad.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(stringBuilder.toString());
        Set<String> resultado = new HashSet<>();
        corpus = patron.matcher(stringBuilder.toString());

        while (corpus.find()) {
            resultado.add(corpus.group(0));

        }

        Set<String> resultadoFormaeado = new HashSet<>();
        Iterator it = resultado.iterator();
        while (it.hasNext()) {
            String app = (String) it.next();
            String formatearApp = "";
            //formatearApp = app.replaceAll("<a\\shref=\\\"", "play.google.com").replaceAll("[><]", "").replaceAll("(div\\sclass=\"(\\w+\\s\\w+)\").replaceAll("(title=)", "Nombre app: ").replaceAll("\"", ""));
            formatearApp = app.replaceAll("a href=", "play.google.com").replaceAll("[><]", "").replaceAll("(div\\sclass=\"(\\w+\\s\\w+)\")", "").replaceAll("(title=)", "Nombre app: ").replaceAll("\"", "");

            resultadoFormaeado.add(formatearApp);

        }

        Actividad actividad = new Actividad(generarID(), texto, resultadoFormaeado);

        return actividad;

    }

    @Override
    public int generarID() {

        return getListaGenerica().size() + 1;

    }

}
