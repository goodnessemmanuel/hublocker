package com.oceanngrsmith.ocheejeh.hublocker.databootstrap;

import com.oceanngrsmith.ocheejeh.hublocker.configurations.AppConfig;
import com.oceanngrsmith.ocheejeh.hublocker.dto.LockerDTO;
import com.oceanngrsmith.ocheejeh.hublocker.models.City;
import com.oceanngrsmith.ocheejeh.hublocker.models.Locker;
import com.oceanngrsmith.ocheejeh.hublocker.models.State;
import com.oceanngrsmith.ocheejeh.hublocker.services.CityService;
import com.oceanngrsmith.ocheejeh.hublocker.services.LockerService;
import com.oceanngrsmith.ocheejeh.hublocker.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

/**
 * load initial
 * database data
 */
@Configuration
public class SpringBootstrapJpa implements ApplicationListener<ContextRefreshedEvent> {

    private  StateService stateService;
    private  CityService cityService;
    private  LockerService lockerService;
    private  AppConfig appConfig;

    @Autowired
    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Autowired
    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }
    @Autowired
    public void setCity(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setLockerService(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.loadData();
    }

    public void loadData() {
        List<LockerDTO> locationLockers = lockerService.listAllLockers().getBody();
        if(locationLockers != null && locationLockers.size() > 0) return;

        State lagos = new State("Lagos", "Center of Commerce");
        State abuja = new State("Abuja", "Center of Unity");
        State rivers = new State("Rivers", "Treasure base of the nation");
        stateService.saveStates(List.of(lagos, abuja, rivers));

        City lekki = new City(lagos, "Lekki");
        City ikeja = new City(lagos, "Ikeja");
        City ajah = new City(lagos, "Ajah");
        City festac = new City(lagos, "Festac");
        lekki = cityService.saveOrUpdate(lekki);
        ikeja = cityService.saveOrUpdate(ikeja);
        ajah = cityService.saveOrUpdate(ajah);
        festac = cityService.saveOrUpdate(festac);

        City obiAkpor = new City(rivers, "Obio/Akpor");
        City ph = new City(rivers, "Portharcourt");
        obiAkpor = cityService.saveOrUpdate(obiAkpor);
        ph = cityService.saveOrUpdate(ph);

        City area1 = new City(abuja, "Area1");
        City gwar = new City(abuja, "Gwarimpa");
        area1 = cityService.saveOrUpdate(area1);
        gwar = cityService.saveOrUpdate(gwar);

        Locker lagosLocker1 = new Locker();
        lagosLocker1.setName("LG34 H295* K460*D520mm");
        lagosLocker1.setPriceDetail("₦150 per Item/mo ₦19,000 XX no of orders Online only price");
        lagosLocker1.setFirstRent("₦3 For First Rent");
        lagosLocker1.setCity(lekki);
        lagosLocker1.setState(lekki.getState());

        Locker lagosLocker2 = new Locker("LG34 P2K5* K433*D520mm",
                "₦320 per Item/mo ₦13,000 XX no of orders Online only price");
        lagosLocker2.setFirstRent("₦3 For First Rent");
        lagosLocker2.setCity(ikeja);
        lagosLocker2.setState(ikeja.getState());

        Locker lagosLocker3 = new Locker("LG34 Q295* W460*D520mm",
                "₦480 per Item/mo ₦24,000 XX no of orders Online only price", "₦1 For First Rent", festac, lagos);
        Locker lagosLocker4 = new Locker("LG34 H295* W460*D520mm",
                "₦280 per Item/mo ₦9,000 XX no of orders Online only price","₦2 For First Rent", ajah, lagos);
        Locker lagosLocker5 = new Locker("LG03 K295* W460*D520mm",
                "₦350 per Item/mo ₦12,000 XX no of orders Online only price", "₦1 For First Rent", ajah, lagos);
        Locker lagosLocker6 = new Locker("LG44 K295* W460*P520mm",
                "₦350 per Item/mo ₦12,000 XX no of orders Online only price", "₦1 For First Rent", festac, lagos);

        lockerService.saveLockers(List.of(lagosLocker1, lagosLocker2, lagosLocker3, lagosLocker3, lagosLocker4, lagosLocker5, lagosLocker6));

        Locker riversLocker1 = new Locker("RV34 H295* W460*D520mm",
                "₦280 per Item/mo ₦17,000 XX no of orders Online only price", "₦1 For First Rent", ph, rivers);
        Locker riversLocker2 = new Locker("RV64 H295* W360*D920mm",
                "₦580 per Item/mo ₦14,000 XX no of orders Online only price","₦1 For First Rent", ph, rivers);
        Locker riversLocker3 = new Locker("RV19 Z295* W360*D920mm",
                "₦300 per Item/mo ₦10,000 XX no of orders Online/Offline only price", "₦1 For First Rent", obiAkpor, rivers);

        lockerService.saveLockers(List.of(riversLocker1, riversLocker2, riversLocker3));

        Locker abujaLocker1 = new Locker("AB34 H295* W460*D520mm",
                "₦280 per Item/mo ₦17,000 XX no of orders Online only price", "₦1 For First Rent",  gwar, abuja);
        Locker abujaLocker2 = new Locker("AB64 H295* W360*D920mm",
                "₦580 per Item/mo ₦14,000 XX no of orders Online only price","₦1 For First Rent", area1, abuja);
        Locker abujaLocker3 = new Locker("AB19 Z295* W360*D920mm",
                "₦300 per Item/mo ₦10,000 XX no of orders Online/Offline only price", "₦1 For First Rent", area1, abuja);
        Locker abujaLocker4 = new Locker("AB11 ZP95* W360*D920mm",
                "₦250 per Item/mo ₦15,000 XX no of orders Online/Offline only price", "₦1 For First Rent", area1, abuja);

        lockerService.saveLockers(List.of(abujaLocker1, abujaLocker2, abujaLocker3, abujaLocker4));

    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList(appConfig.getUrl()));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
