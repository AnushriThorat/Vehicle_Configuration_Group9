# =========================================================
# BUILD STAGE
# =========================================================

FROM mcr.microsoft.com/dotnet/sdk:10.0 AS build

WORKDIR /src

# Copy project file first
COPY *.csproj ./

# Restore NuGet packages
RUN dotnet restore

# Copy source code
COPY . .

# Build and publish
RUN dotnet publish \
    -c Release \
    -o /app/publish \
    /p:UseAppHost=false


# =========================================================
# RUNTIME STAGE
# =========================================================

FROM mcr.microsoft.com/dotnet/aspnet:10.0

WORKDIR /app

COPY --from=build /app/publish .

# ASP.NET Core listens on port 8080 inside container
ENV ASPNETCORE_URLS=http://+:8080

EXPOSE 8080

ENTRYPOINT ["dotnet", "DotNetBackend.dll"]