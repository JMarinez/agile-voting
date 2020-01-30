package org.dominisoft.scrumdev.claro2020;

import org.dominisoft.scrumdev.claro2020.domain.DopNationalIdentificationNumber;

import io.javalin.Javalin;

/**
 * Hello world.
 *
 */
public final class App {
  /**
   * Default port.
   */
  public static final int DEFAULT_PORT = 7000;

  private static Javalin app;

  /**
   * Prevent instantiation.
   */
  private App() {
  }
  
  /**
   * Entry point.
   *
   * @param args Console arguments
   */
  public static void main(String[] args) {
    app = Javalin.create(config -> {
      config.addStaticFiles("/html");
    }).start(DEFAULT_PORT);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      app.stop();
    }));

    app.events(event -> {
      event.serverStopping(() -> {
        System.out.println("The server is stopping.");
      });
      event.serverStopped(() -> {
        System.out.println("Server is gone!");
      });
    });

    app.post("/init-voting", ctx -> {
      ctx.contentType("text/html; charset=UTF-8");
      final String rawCedula = ctx.req.getParameter("id");

       DopNationalIdentificationNumber cedula2 = new DopNationalIdentificationNumber(rawCedula);

      ctx.result(
          String.format("TODO: Validate ID '%s' (Cédula)!!!", cedula2.getValue()));
    });
    
    app.exception(Exception.class, (e, ctx) -> {
        System.out.print("Fallo");
    });

    app.after(ctx -> {
      // run after all requests
      final String whatHappened = ctx.req.getMethod() + " "
          + ctx.req.getRequestURI() + " -> " + ctx.res.getStatus();
      System.out.println("whatHappened: " + whatHappened);
    });
  }

  /**
   * Stops the server.
   */
  public static void stop() {
    app.stop();
  }
}
