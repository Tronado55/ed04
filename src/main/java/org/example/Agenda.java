package org.example;

import java.util.*;

/**
* La clase Agenda gestiona una lista de contactos.
* Permite añadir, eliminar y modificar contactos y sus números de teléfono.
*
* @author TuNombre
* @version 1.0
* @since 2025
*/
public class Agenda {
    private List<Contacto> contacts; // Lista de Contacto

    /**
     * Constructor que inicializa la lista de contactos.
     */
    public Agenda() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Añade un contacto a la agenda. Si el contacto ya existe, añade el número de teléfono al contacto existente.
     *
     * @param name el nombre del contacto
     * @param phone el número de teléfono del contacto
     */
    public void addContact(String name, String phone) {
        boolean exists = false;
        for (Contacto c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                exists = true;
                c.getPhones().add(phone);
                break;
            }
        }

        if (!exists) {
            Contacto newContact = new Contacto(name, phone);
            contacts.add(newContact);
        }
    }

    /**
            * Elimina un contacto de la agenda por su nombre.
     *
             * @param name el nombre del contacto a eliminar
     */
    public void removeContact(String name) {
        Iterator<Contacto> it = contacts.iterator();

        while (it.hasNext()) {
            Contacto c = it.next();

            if (c.getName().equalsIgnoreCase(name)) {
                it.remove();
            }
        }
    }

    /**
     * Modifica el número de teléfono de un contacto existente.
     *
     * @param name el nombre del contacto
     * @param oldPhone el número de teléfono antiguo
     * @param newPhone el nuevo número de teléfono
     */
    public void modifyPhoneNumber(String name, String oldPhone, String newPhone) {
        for (Contacto c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                List<String> phones = c.getPhones();

                int index = phones.indexOf(oldPhone);

                if (index != -1) {
                    phones.set(index, newPhone);
                }
            }
        }
    }

    /**
     * Obtiene la lista de contactos.
     *
     * @return la lista de contactos
     */
    public List<Contacto> getContacts() {
        return this.contacts;
    }
}