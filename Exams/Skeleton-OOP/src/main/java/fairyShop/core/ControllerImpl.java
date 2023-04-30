package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type){
            case "Happy" :
                helper = new Happy(helperName);
                break;
            case "Sleepy" :
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }

        helperRepository.add(helper);

        return String.format(ADDED_HELPER,type,helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if (helper == null){
                throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);

        helper.getInstruments().add(instrument);

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER,power,helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName,energyRequired);

        presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT,presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> validHelpers = helperRepository.getModels()
                .stream()
                .filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());

        if (validHelpers.isEmpty()){
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        int brokenInstruments = 0;
        Present present = presentRepository.findByName(presentName);

        for (Helper helper : validHelpers) {
           shop.craft(present,helper);
           brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
           if (present.isDone()){
               break;
           }
        }

        if (present.isDone()){
            return String.format(PRESENT_DONE,presentName,"done") +
                    String.format(COUNT_BROKEN_INSTRUMENTS,brokenInstruments);
        }
        return String.format(PRESENT_DONE,presentName,"not done") +
                String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        long presentsDone = presentRepository.getModels().stream().filter(Present::isDone).count();

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s presents are done!",presentsDone)).append(System.lineSeparator());
        builder.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : helperRepository.getModels()) {
            builder.append(String.format("Name: %s",helper.getName())).append(System.lineSeparator());
            builder.append(String.format("Energy: %s",helper.getEnergy())).append(System.lineSeparator());
            builder.append(String.format("Instruments: %d not broken left",helper.getInstruments()
                    .stream()
                    .filter(i -> !i.isBroken()).count()));
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
