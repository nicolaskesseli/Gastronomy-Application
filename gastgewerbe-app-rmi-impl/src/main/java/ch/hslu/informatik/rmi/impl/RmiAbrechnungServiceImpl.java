package ch.hslu.informatik.rmi.impl;

import ch.hslu.informatik.gastgewerbe.api.AbrechnungService;
import ch.hslu.informatik.gastgewerbe.businessabrechnung.AbrechnungManager;
import ch.hslu.informatik.gastgewerbe.model.Abrechnung;
import ch.hslu.informatik.gastgewerbe.model.Benutzer;
import ch.hslu.informatik.gastgewerbe.model.Tisch;
import ch.hslu.informatik.gastgewerbe.rmi.api.RmiAbrechnungService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RmiAbrechnungServiceImpl extends UnicastRemoteObject implements RmiAbrechnungService {

    private AbrechnungService abrechungService;

    public RmiAbrechnungServiceImpl() throws RemoteException {

    }

    public AbrechnungService getAbrechungService() {

        if (abrechungService == null) {
            abrechungService = new AbrechnungManager() {
            };
        }

        return abrechungService;
    }

    @Override
    public double tischAbrechnen(Tisch tisch, Benutzer benutzer) throws Exception {
        return getAbrechungService().tischAbrechnen(tisch, benutzer);
    }

    @Override
    public double abschluss(LocalDate zeit) throws Exception {
        return getAbrechungService().abschluss(zeit);
    }

    @Override
    public List<Abrechnung> findByBenutzerUndDatum(Benutzer benutzer, LocalDate zeit) throws Exception {
        return getAbrechungService().findByBenutzerUndDatum(benutzer, zeit);
    }
}
