/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.codec.binary.Base64;
import ups.edu.ec.modelo.Administrador;

/**
 *
 * @author User
 */
public class ControladorAdministrador extends Controlador<Administrador> {

    private Pattern patron;
    private Matcher corpus;

    public ControladorAdministrador() {
        patron = Pattern.compile("^(\\w){2,}(\\@)(\\w){2,}(\\.\\w{2,})+$");

    }

    public boolean validarEmail(String email) {

        corpus = patron.matcher(email);

        return corpus.find();

    }

    public Administrador findByCedula(String cedula) {
        Query consulta = getEm().createNamedQuery("Administrador.findByCedula");
        consulta.setParameter("cedula", cedula);
        return (Administrador) consulta.getSingleResult();
    }

    public Administrador iniciarSesion(String correo, String password, String keyUnlock) {
        var listaAdmins = (List<Administrador>) findAll();
        Administrador admin = null;
        try {
            admin = listaAdmins.stream().filter(ad -> ad.getCorreo().equals(correo)
                    && desencriptarPassword(keyUnlock, ad.getPassword()).equals(password)).findFirst().get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        if (Administrador.instance == null) {
            Administrador.instance = (Administrador) admin;
            return Administrador.instance;
        } else {
            return null;
        }

    }

    public String encriptarPassword(String key, String password) {

        String encriptacion = "";

        try {

            MessageDigest msmd = MessageDigest.getInstance("MD5");
            byte[] llavePassword = msmd.digest(key.getBytes("utf-8"));
            byte[] bytesKey = Arrays.copyOf(llavePassword, 24);

            SecretKey secretKey = new SecretKeySpec(bytesKey, "DESede");

            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] bytesPassword = password.getBytes("utf-8");
            byte[] buffer = cifrado.doFinal(bytesPassword);

            byte[] base64Bytes = Base64.encodeBase64(buffer);

            encriptacion = new String(base64Bytes);

            return encriptacion;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encriptacion;
    }

    public String desencriptarPassword(String key, String passwordEncriptado) {

        String desincriptacion = "";

        try {

            byte[] mensaje = Base64.decodeBase64(passwordEncriptado.getBytes("utf-8"));
            MessageDigest msmd = MessageDigest.getInstance("MD5");

            byte[] llavePassword = msmd.digest(key.getBytes("utf-8"));
            byte[] bytesKey = Arrays.copyOf(llavePassword, 24);

            SecretKey secretKey = new SecretKeySpec(bytesKey, "DESede");

            Cipher decifrado = Cipher.getInstance("DESede");
            decifrado.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] cadenaDesencriptada = decifrado.doFinal(mensaje);

            desincriptacion = new String(cadenaDesencriptada, "utf-8");

            return desincriptacion;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return desincriptacion;
    }

    @Override
    public List<Administrador> findAll() {
        Query consulta = getEm().createNamedQuery("Administrador.findAll");

        //System.out.println("rrrrr" + consulta.getResultList());
        return consulta.getResultList();
    }

    @Override
    public int getCodigo() {
        var lista = findAll();

        Collections.sort(lista, (Administrador f1, Administrador f2) -> f1.getCodigo() - (f2.getCodigo()));

        return lista.get(lista.size() - 1).getCodigo();

    }
}
