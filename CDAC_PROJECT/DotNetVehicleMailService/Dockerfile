# =========================================================
# BUILD STAGE
# =========================================================

FROM mcr.microsoft.com/dotnet/sdk:10.0 AS build

WORKDIR /src

# Copy project file
COPY *.csproj ./

# Restore NuGet packages
RUN dotnet restore

# Copy source code
COPY . .

# Publish application
RUN dotnet publish \
    -c Release \
    -o /app/publish \
    /p:UseAppHost=false


# =========================================================
# RUNTIME STAGE
# =========================================================

FROM mcr.microsoft.com/dotnet/aspnet:10.0

WORKDIR /app

# Copy published application
COPY --from=build /app/publish .

# ASP.NET Core listens on port 8080
ENV ASPNETCORE_URLS=http://+:8080

EXPOSE 8080

ENTRYPOINT ["dotnet", "VehicleMailService.dll"]